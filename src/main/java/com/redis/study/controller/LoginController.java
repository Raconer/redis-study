package com.redis.study.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/login")
    public String login(HttpSession session, @RequestParam String name){
        session.setAttribute("name", name);

        return "saved";
    }

    @GetMapping("/maName")
    public String myName(HttpSession session){

        return (String)session.getAttribute("name");
    }
}
