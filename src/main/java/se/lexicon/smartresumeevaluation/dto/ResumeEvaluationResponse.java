package se.lexicon.smartresumeevaluation.dto;

import java.util.List;

public record ResumeEvaluationResponse(
        int matchScore,
        List<String> strengths,
        List<String> missingSkills,
        List<String> feedback,
        String summary
) {
}
