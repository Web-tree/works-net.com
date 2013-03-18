package com.worksnet.controller;

import com.worksnet.model.Work;
import com.worksnet.service.WorkService;
import com.worksnet.validator.WorkValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author maxim.levicky
 *         Date: 2/20/13
 *         Time: 3:12 PM
 */
@Controller
public class WorkController extends BaseController {
    @Autowired
    protected WorkService service;

    @Autowired
    private WorkValidator workValidator;

    @RequestMapping(value = "/work", method = RequestMethod.GET)
    public ModelAndView get() {
        return new ModelAndView()
                .addObject("works", service.getList())
                .addObject("work", new Work());
    }

    @RequestMapping(value = "/work", method = RequestMethod.POST)
    public String add(@ModelAttribute("work") Work work, BindingResult result) {
        workValidator.validate(work, result);

        if (result.hasErrors()) {
            return "/work";
        }
        service.update(work);
        return "redirect:/work";
    }


    @RequestMapping(value = "/work/{id}/{action}")
    public String edit(@PathVariable String id, @PathVariable String action, Model model) {
        Work work = service.getById(Integer.parseInt(id));
        switch (action) {
            case "edit":
                model.addAttribute("work", work);
                break;
            case "delete":
                service.delete(work);
                return "redirect:/work";
        }
        return "/work";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
