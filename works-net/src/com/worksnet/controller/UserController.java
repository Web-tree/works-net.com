package com.worksnet.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.worksnet.model.User;
import com.worksnet.service.UserService;
import com.worksnet.validator.UserValidator;

/**
 * @author maxim.levicky
 *         Date: 2/20/13
 *         Time: 3:12 PM
 */
@Controller
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping("/")
    public String foo() {
        return "redirect:user";
    }


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public void get(Model model) {
        model.addAttribute("people", service.getList());
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@ModelAttribute("user") User user, BindingResult result) {
        userValidator.validate(user, result);
        if (result.hasErrors()) { return "/users"; }
        service.update(user);
        return "redirect:/user";
    }


    @RequestMapping(value = "/user/{id}/{action}", method = RequestMethod.GET)
    public String edit(@PathVariable String id, @PathVariable String action, Model model) {
        User user = service.getById(Long.parseLong(id));

        if (action.equals("delete")) {
            service.delete(user);
            return "redirect:/user";
        }

        if (action.equals("edit")) { model.addAttribute("user", user); }
        return "/users";


    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
