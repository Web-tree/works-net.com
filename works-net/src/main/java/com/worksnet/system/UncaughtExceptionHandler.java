package com.worksnet.system;

import org.springframework.core.Ordered;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author maxim.levicky
 */
public class UncaughtExceptionHandler implements HandlerExceptionResolver  {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView("error/generalError");
        modelAndView.addObject("errorMessage", "Unexpected error");
        return modelAndView;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
