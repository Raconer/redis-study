package com.redis.study.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ExternalApiService {
    public String getUserName(String userId){

        // 외부 서비스나 DB 호출 0.5s 지연
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){

        }
        log.info("Getting user name from other service...");

        if(userId.equals("A")){
            return "Adam";
        }
        if(userId.equals("B")){
            return "Bob";
        }

        return "";
    }

    // 이 방법을 추천한다.
    @Cacheable(cacheNames = "userAgeCache", key = "#userId")
    public int getUserAge(String userId){

        // 외부 서비스나 DB 호출 0.5s 지연
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){
        }

        log.info("Getting user age from other service...");

        if(userId.equals("A")){
            return 28;
        }
        if(userId.equals("B")){
            return 32;
        }

        return 0;
    }
}
