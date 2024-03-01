package com.redis.study.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RankingServiceTest {

    @Autowired
    private RankingService rankingService;

    @Test
    void inMemorySortPerformance() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            int score = (int) (Math.random() * 1000000);
            list.add(score);
        }
        Instant before = Instant.now();
        Collections.sort(list); // nlogn -> Quick Sort
        Duration elapsed =  Duration.between(before, Instant.now());
        System.out.println((elapsed.getNano() / 1000000) + " ms");
    }

//    @Test
//    void setUserScore() {
//        for (int i = 0; i < 1000000; i++) {
//            int score = (int) (Math.random() * 1000000);
//            String userId = "user_" + i;
//            this.rankingService.setUserScore(userId, score);
//        }
//    }

    @Test
    void getUserRanking() {
        Instant before = Instant.now();
        Long userRank = this.rankingService.getUserRanking("user_100");
        Duration elapsed = Duration.between(before, Instant.now());

        System.out.println(String.format("Rank(%d) - Took %d ms", userRank, elapsed.getNano() / 1000000));
    }
}