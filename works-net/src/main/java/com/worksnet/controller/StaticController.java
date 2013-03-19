package com.worksnet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author maxim.levicky
 *         Date: 3/19/13
 *         Time: 3:19 PM
 */
@Controller
public class StaticController extends BaseController {
    @RequestMapping(value = "/")
    public String rootPage() {
        return "/rootPage";
    }
}
