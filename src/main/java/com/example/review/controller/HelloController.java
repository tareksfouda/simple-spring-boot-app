package com.example.review.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @GetMapping({"/", "/hello"})
    public ModelAndView hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
    	ModelAndView view = new ModelAndView();
        view.addObject("name", name);
        return view;
    }
}
