package com.zack.controller;

import com.zack.exception.BizException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/temp")
public class TempController {
    @RequestMapping("Biz")
    public ModelAndView biz() {
        throw new RuntimeException("test");
    }

    @RequestMapping("BizAjax")
    @ResponseBody
    public ModelAndView view() {
        throw new BizException("ajax error");
    }
}
