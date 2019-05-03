package com.smith.gamingLab.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping("/home")
    @ResponseBody
    private ClassPathResource home() {
        return new ClassPathResource("/index.html");
    }

    @RequestMapping("/game/search")
    @ResponseBody
    private ClassPathResource search() {
        return new ClassPathResource("/index.html");
    }

    

}