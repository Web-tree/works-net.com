package com.worksnet.controller;

import com.worksnet.model.User;
import com.worksnet.service.MailService;
import com.worksnet.service.UserService;
import com.worksnet.utils.MailMessageBuilder;
import com.worksnet.validator.RegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author maxim.levicky
 *         Date: 3/25/13
 *         Time: 10:57 AM
 */
@Controller
public class AuthController extends BaseController {
    @Autowired
    private RegistrationValidator validator;

    //    @Autowired
//    @Qualifier("userService")
    private UserService service;

    @Autowired
    private MailService mailService;

    @Autowired
    private MailMessageBuilder mailMessageBuilder;

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

//        mailService.sendEmailConfirmation(user, RequestContextUtils.getLocale(request));

        service.add(user);

        return "redirect:/confirm/info";
    }

    @RequestMapping(value = "/confirm/info", method = RequestMethod.GET)
    public String confirmInfo() {
        return "/auth/registerConfirmInfo";
    }
}
