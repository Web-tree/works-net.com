package com.worksnet.controller;

import com.worksnet.system.Conf;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: maxim.levicky
 * Date: 4/10/13
 * Time: 5:56 PM
 */
@Controller
public class OAuthController extends BaseController {
    @RequestMapping(value = "/oauth/github")
    public String githubAuthPage(Model model){
        model.addAttribute("clientId", Conf.get("github.clientId"));
        return "auth/oauth/github/auth";
    }
}
