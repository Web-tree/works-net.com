package com.worksnet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.worksnet.model.User;
import com.worksnet.service.UserService;
import com.worksnet.validator.RegistrationValidator;

/**
 * @author maxim.levicky
 *         Date: 3/25/13
 *         Time: 10:57 AM
 */
@Controller
public class AuthController extends BaseController {
    @Autowired
    private RegistrationValidator validator;

    @Qualifier("userService")
    @Autowired
    private UserService service;

    @RequestMapping(value = "/login")
    public String login() {
        return "/auth/login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "/auth/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid User user, BindingResult result, HttpServletRequest request) {
        validator.validate(user, result, service);

        if (result.hasErrors()) {
            return "/auth/register";
        }

        service.add(user);

        return "redirect:/login";
    }

    public void setService(UserService service) {
        this.service = service;
    }
}
