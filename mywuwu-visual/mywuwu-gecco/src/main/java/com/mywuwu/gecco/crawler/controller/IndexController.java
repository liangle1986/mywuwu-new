package com.mywuwu.gecco.crawler.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 * 首页控制层
 * @author wisdom
 * @since 2019-04-15
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @GetMapping({"","/"})
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("index");
        return view;
    }

    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView view = new ModelAndView("home");
        return view;
    }

}
