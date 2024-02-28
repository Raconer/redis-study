package com.redis.study.service;

import org.springframework.stereotype.Service;

@Service
public class ExternalApiService {
    public String getUserName(String userId){

        // 외부 서비스나 DB 호출 0.5s 지연
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){

        }

        if(userId.equals("A")){
            return "Adam";
        }
        if(userId.equals("B")){
            return "Bob";
        }

        return "";
    }

    public int getUserAge(String userId){

        // 외부 서비스나 DB 호출 0.5s 지연
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){
        }

        if(userId.equals("A")){
            return 28;
        }
        if(userId.equals("B")){
            return 32;
        }

        return 0;
    }
}
