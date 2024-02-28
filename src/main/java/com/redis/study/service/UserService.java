package com.redis.study.service;

import com.redis.study.dto.UserProfile;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {

    private ExternalApiService externalApiService;
    private StringRedisTemplate stringRedisTemplate;

    public UserProfile getUserProfile(String userId){

        ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
        String userName = null;
        int userAge = 0;

        String cachedName = ops.get("nameKey:" + userId);
        if(cachedName != null){
            userName = cachedName;
        } else {
            userName = this.externalApiService.getUserName(userId);

            ops.set("nameKey:" + userId, userName, 5, TimeUnit.SECONDS);
        }

        userAge = this.externalApiService.getUserAge(userId);

        return new UserProfile(userName, userAge);
    }
}
