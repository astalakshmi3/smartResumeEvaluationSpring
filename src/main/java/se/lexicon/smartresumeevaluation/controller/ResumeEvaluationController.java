package se.lexicon.smartresumeevaluation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import se.lexicon.smartresumeevaluation.dto.ResumeEvaluationRequest;
import se.lexicon.smartresumeevaluation.dto.ResumeEvaluationResponse;
import se.lexicon.smartresumeevaluation.service.ResumeEvaluationService;

@RestController
@RequestMapping("/api/v1/resume")
@Validated
public class ResumeEvaluationController {
    private final ResumeEvaluationService resumeEvaluationService;

    public ResumeEvaluationController(ResumeEvaluationService resumeEvaluatorService) {
        this.resumeEvaluationService = resumeEvaluatorService;
    }

    @PostMapping("/evaluate")
    public ResumeEvaluationResponse evaluate(@RequestBody ResumeEvaluationRequest request) {
        return resumeEvaluationService.evaluate(request);
    }
}