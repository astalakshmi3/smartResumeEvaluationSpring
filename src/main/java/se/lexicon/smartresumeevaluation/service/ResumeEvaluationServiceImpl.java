package se.lexicon.smartresumeevaluation.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.stereotype.Service;
import se.lexicon.smartresumeevaluation.dto.ResumeEvaluationRequest;
import se.lexicon.smartresumeevaluation.dto.ResumeEvaluationResponse;

@Service
public class ResumeEvaluationServiceImpl implements ResumeEvaluationService {

    private final ChatClient chatClient;

    public ResumeEvaluationServiceImpl(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @Override
    public ResumeEvaluationResponse evaluate(ResumeEvaluationRequest request) {

        if (chatClient == null) {
            throw new IllegalStateException("Chat client is not available");
        }
        BeanOutputConverter<ResumeEvaluationResponse> converter =
                new BeanOutputConverter<>(ResumeEvaluationResponse.class);

        String prompt = """
                You are a Senior Technical Recruiter with 20 years of experience.
                
                Compare the resume with the job description.
                
                Resume:
                %s
                
                Job Description:
                %s
                 Tasks:
                                - Give a match score from 0 to 100
                                - Identify candidate strengths
                                - Identify missing skills
                                - Give clear improvement feedback
                                - Write a short summary
                
                                Return only valid JSON using this structure:
                                %s
                """.formatted(
                request.resumeText(),
                request.jobDescriptionText(),
                converter.getFormat()
        );
        String response = chatClient.prompt()
                .user(prompt)
                .call()
                .content();

        return converter.convert(response);
    }
}