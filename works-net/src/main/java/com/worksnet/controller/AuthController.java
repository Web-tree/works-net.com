package com.worksnet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Max Levicky
 *         Date: 20.03.13
 *         Time: 19:36
 */
@Controller
public class AuthController {
    @RequestMapping(value = "/login")
    public String login() {
        return "/auth/login";
    }
}
