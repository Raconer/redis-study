package com.redis.study.service;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class RankingService {
    private static final String LEADERBOARD_KEY = "leaderBoard";
    private StringRedisTemplate stringRedisTemplate;


    public boolean setUserScore(String userId, int score){
        ZSetOperations<String, String> zSetOps = this.stringRedisTemplate.opsForZSet();
        zSetOps.add(LEADERBOARD_KEY, userId, score);
        return true;
    }

    public Long getUserRanking(String userId){
        ZSetOperations<String, String> zSetOps = this.stringRedisTemplate.opsForZSet();
        return zSetOps.reverseRank(LEADERBOARD_KEY, userId);
    }

    public List<String> getTopRank(int limit){
        ZSetOperations<String, String> zSetOps = this.stringRedisTemplate.opsForZSet();
        Set<String> rangeSet = zSetOps.reverseRange(LEADERBOARD_KEY, 0, limit - 1);
         if(rangeSet != null) return new ArrayList<>(rangeSet);
         else return new ArrayList<>();
    }
}
