package com.worksnet.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.worksnet.model.Work;
import com.worksnet.service.UserService;
import com.worksnet.service.WorkService;
import com.worksnet.validator.WorkValidator;

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
    public ModelAndView get() {
        return new ModelAndView()
                .addObject("works", service.getList())
                .addObject("work", new Work());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getOne(@PathVariable String id, Model model) {
        model.addAttribute("work", service.getById(Integer.parseInt(id)));
        return "/work/single";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String add(@ModelAttribute("work") Work work, BindingResult result) {
        workValidator.validate(work, result);

        work.setOwnerId(UserService.getCurrentUser().getId());

        if (result.hasErrors()) {
            return "/work";
        }
        service.update(work);
        return "redirect:/work";
    }


    @RequestMapping(value = "/{id}/{action}")
    public String edit(@PathVariable int id, @PathVariable String action, Model model) {
        Work work = service.getById(id);
        switch (action) {
            case "edit":
                model.addAttribute("work", work);
                break;
            case "delete":
                service.delete(work);
                return "redirect:/work";
        }
        return "/work/" + id + "/" + action;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
