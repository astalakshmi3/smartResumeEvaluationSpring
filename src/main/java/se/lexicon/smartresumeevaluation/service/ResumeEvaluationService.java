package se.lexicon.smartresumeevaluation.service;

import se.lexicon.smartresumeevaluation.dto.ResumeEvaluationRequest;
import se.lexicon.smartresumeevaluation.dto.ResumeEvaluationResponse;

public interface ResumeEvaluationService {
    ResumeEvaluationResponse evaluate(ResumeEvaluationRequest request);

}
