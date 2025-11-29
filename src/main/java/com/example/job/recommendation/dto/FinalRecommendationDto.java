package com.example.job.recommendation.dto;

import lombok.Data;

@Data
public class FinalRecommendationDto {
    private Long companyId;
    private String companyName;
    private int matchScore;
    private JobPostingDto jobPosting; // 실시간 공고 정보
}