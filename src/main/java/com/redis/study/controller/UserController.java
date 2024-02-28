package com.redis.study.controller;

import com.redis.study.dto.UserProfile;
import com.redis.study.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/{userId}/profile")
    public UserProfile getUserProfile(@PathVariable(value = "userId") String userId){
        return this.userService.getUserProfile(userId);
    }

}
