package com.worksnet.controller;

import com.worksnet.model.User;
import com.worksnet.service.UserService;
import com.worksnet.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author maxim.levicky
 *         Date: 2/20/13
 *         Time: 3:12 PM
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @Qualifier("userService")
    @Autowired
    protected UserService service;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getList(Model model) {
        model.addAttribute("users", service.getList());
        return "/user/list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getSingle(@PathVariable int id, Model model) {
        model.addAttribute("user", service.getById(id));
        return "/user/single";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getAdmin(Model model) {
        model
                .addAttribute("templateName", "user")
                .addAttribute("users", service.getList())
                .addAttribute("user", new User());
        return "/user/admin";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String add(@ModelAttribute("user") User user, BindingResult result) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "/user";
        }
        service.update(user);
        return "redirect:/user";
    }


    @RequestMapping(value = "/{id}/{action}")
    public String edit(@PathVariable String id, @PathVariable String action, Model model) {
        User user = service.getById(Integer.parseInt(id));
        if (action.equals("delete")) {
            service.delete(user);
            return "redirect:/user";
        }

        if (action.equals("edit")) {
            model.addAttribute("user", user);
        }
        return "/user";
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    public void setService(UserService service) {
        this.service = service;
    }
}
