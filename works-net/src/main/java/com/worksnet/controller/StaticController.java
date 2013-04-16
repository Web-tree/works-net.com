package com.worksnet.controller;

import com.worksnet.model.User;
import com.worksnet.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.Map;

/**
 * @author maxim.levicky
 *         Date: 3/19/13
 *         Time: 3:19 PM
 */
@Controller
public class StaticController extends BaseController {
    @RequestMapping(value = "/")
    public String rootPage() {
        return "/static/rootPage";
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody User test() {
        return UserService.getCurrentUser();
    }
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testPage() {
        return "/static/test";
    }
}
