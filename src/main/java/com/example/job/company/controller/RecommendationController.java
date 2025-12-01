package com.example.job.company.controller;

import com.example.job.company.service.RecommendationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import com.example.job.company.dto.RecommendationDto;
@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<RecommendationDto>> getRecommendations(@PathVariable Long memberId) {
        List<RecommendationDto> recommendations = recommendationService.recommendCompanies(memberId);
        return ResponseEntity.ok(recommendations);
    }
}
