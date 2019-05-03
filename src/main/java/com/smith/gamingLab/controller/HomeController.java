package com.smith.gamingLab.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

//    @RequestMapping("/admin")
//    @ResponseBody
//    private ClassPathResource admin() {
//        return new ClassPathResource("/index.html");
//    }

    @RequestMapping("/game/about")
    @ResponseBody
    private ClassPathResource about() {
        return new ClassPathResource("/index.html");
    }

    @RequestMapping("/login")
    @ResponseBody
    private ClassPathResource login() {
        return new ClassPathResource("/index.html");
    }

    @RequestMapping("/admin/addgame")
    @ResponseBody
    private ClassPathResource addgame() {
        return new ClassPathResource("/index.html");
    }


    @RequestMapping("/admin/search")
    @ResponseBody
    private ClassPathResource admingSearch() {
        return new ClassPathResource("/index.html");
    }

    @RequestMapping("/admin/editgenre")
    @ResponseBody
    private ClassPathResource editGenre() {
        return new ClassPathResource("/index.html");
    }

    @RequestMapping("/admin/editconsole")
    @ResponseBody
    private ClassPathResource editConsole() {
        return new ClassPathResource("/index.html");
    }

    @RequestMapping("/admin/editmode")
    @ResponseBody
    private ClassPathResource editMode() {
        return new ClassPathResource("/index.html");
    }

    @RequestMapping("/admin/editgame")
    @ResponseBody
    private ClassPathResource editGame(@RequestParam int gameId) {
        return new ClassPathResource("/index.html");
    }

}