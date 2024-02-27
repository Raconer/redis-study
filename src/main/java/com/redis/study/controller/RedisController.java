package com.redis.study.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RedisController {

    private final StringRedisTemplate redisTemplate;

    @GetMapping("/setFruit")
    public String set(@RequestParam String name){
        ValueOperations<String, String> ops = this.redisTemplate.opsForValue();
        ops.set("fruit", name);

        return "saved";
    }

    @GetMapping("/getFruit")
    public String get(){
        ValueOperations<String, String> ops = this.redisTemplate.opsForValue();
        return ops.get("fruit");
    }


}
