package com.redis.study.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final StringRedisTemplate redisTemplate;

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
