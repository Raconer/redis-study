package com.redis.study;

import com.redis.study.service.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
@AllArgsConstructor
public class RedisStudyApplication implements CommandLineRunner {

    private ChatService chatService;

    public static void main(String[] args) {
        SpringApplication.run(RedisStudyApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application started..");
        this.chatService.enterChatRoom("Chat1");

    }
}

