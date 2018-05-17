package com.zack.controller;

import com.zack.exception.BizException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(BizException.class)
    public ModelAndView handleBizException(Exception e, HttpServletRequest request) {
        return commonHandle(e.getMessage(), request);
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleUnexpectedException(Exception e, HttpServletRequest request) {
        return commonHandle("系统错误", request);
    }

    private boolean isAjax(HttpServletRequest request) {
        return request.getHeader("accept").contains("application/json")
                || request.getHeader("X-Requested-With") != null
                && request.getHeader("X-Requested-With").contains("XMLHttpRequest");
    }

    private ModelAndView commonHandle(String message, HttpServletRequest request) {
        if (isAjax(request)) {
            ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
            modelAndView.addObject("msg", message);
            return modelAndView;
        } else {
            return new ModelAndView("error");
        }
    }
}
