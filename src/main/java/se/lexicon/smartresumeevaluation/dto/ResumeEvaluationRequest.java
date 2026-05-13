package se.lexicon.smartresumeevaluation.dto;

import jakarta.validation.constraints.NotNull;

public record ResumeEvaluationRequest(
        @NotNull(message = "Resume text must not be null")
        String resumeText,
        @NotNull (message = "Job description text must not be null")
        String jobDescriptionText
) {
}
