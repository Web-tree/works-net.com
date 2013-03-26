package com.worksnet.controller;

import com.worksnet.model.Work;
import com.worksnet.model.workdetails.WorkDetail;
import com.worksnet.service.UserService;
import com.worksnet.service.WorkService;
import com.worksnet.validator.WorkValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author maxim.levicky
 *         Date: 2/20/13
 *         Time: 3:12 PM
 */
@Controller
@RequestMapping(value = "/work")
public class WorkController extends BaseController {
    @Autowired
    protected WorkService service;

    @Autowired
    private WorkValidator workValidator;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getList(Model model) {
        model.addAttribute("works", service.getList());
        return "/work/list";
    }

    @RequestMapping(value = "/my", method = RequestMethod.GET)
    public String getMyWorks(Model model) {
        model.addAttribute("works", service.getListByOwner(UserService.getCurrentUser().getId()));
        return "/work/list";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getAdmin(Model model) {
        model.addAttribute("works", service.getList());
        model.addAttribute("work", new Work());
        return "/work/admin";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getOne(@PathVariable String id, Model model) {
        model.addAttribute("work", service.getById(Integer.parseInt(id)));
        return "/work/single";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPage(@ModelAttribute("work") Work work) {
        return "work/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addWork(@ModelAttribute("work") Work work, BindingResult result) {
        workValidator.validate(work, result);

        work.setOwnerId(UserService.getCurrentUser().getId());

        if (result.hasErrors()) {
            return "/work/add";
        }
        service.add(work);
        return "redirect:/work";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("work") Work work, BindingResult result, HttpServletRequest request) {
        workValidator.validate(work, result);
        if (work.getId() == 0) {
            work.setOwnerId(UserService.getCurrentUser().getId());
        } else {
            checkOwner(work);
        }
        service.saveOrUpdate(work);
        return getBackRedirect(request);
    }

    @RequestMapping(value = "/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        Work work = service.getById(id);
        checkOwner(work);
        model.addAttribute("work", work);
        return "/work/edit";
    }

    @RequestMapping(value = "/{id}/delete")
    public String delete(@PathVariable int id) {
        Work work = service.getById(id);
        checkOwner(work);
        service.delete(work);
        return "redirect:/work";
    }

    @RequestMapping(value = "details/save", method = RequestMethod.POST)
    public String addDetails(@ModelAttribute("workDetails") WorkDetail details, HttpServletRequest request) {

        return getBackRedirect(request);
    }

    protected void checkOwner(Work work) throws AccessDeniedException {
        if (work.getOwnerId() != UserService.getCurrentUser().getId()) {
            throw new AccessDeniedException("Wrong owner");
        }
    }

    protected String getBackRedirect(HttpServletRequest request) {
        String referer = request.getHeader("Referer");
        String redirect = "redirect:";
        if (referer == null) {
            redirect += "/work";
        } else {
            redirect += referer;
        }
        return redirect;
    }
}
