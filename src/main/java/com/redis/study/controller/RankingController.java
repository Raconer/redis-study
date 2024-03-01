package com.redis.study.controller;

import com.redis.study.service.RankingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/ranking")
public class RankingController {
    private RankingService rankingService;

    @GetMapping("/setScore")
    public Boolean setScore(@RequestParam String userId, @RequestParam int score) {
        return this.rankingService.setUserScore(userId, score);
    }

    @GetMapping("/getRank")
    public Long getUserRank(@RequestParam String userId) {
        return this.rankingService.getUserRanking(userId);
    }

    @GetMapping("/getTopRank")
    public List<String> getTopRank(@RequestParam int limit) {
        return this.rankingService.getTopRank(limit);
    }
}
