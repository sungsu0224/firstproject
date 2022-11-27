package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    public String niceToMeetYou(Model model){
        model.addAttribute("userName","김성수 ");
        return "greetings"; // teplates/greetings.mustache -> 브라우저 전송!
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model){
        model.addAttribute("nickname","성수");
        return "goodbye";
    }

}
