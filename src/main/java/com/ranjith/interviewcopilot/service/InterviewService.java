package com.ranjith.interviewcopilot.service;

import org.springframework.stereotype.Service;

@Service
public class InterviewService {

    private final OpenAIService openAIService;

    public InterviewService(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    public String getQuestion(String type, String difficulty) {
        String prompt = String.format("""
                Act as a senior software engineer interviewer.

                Ask ONE %s level %s interview question.

                Rules:
                - Ask only one question
                - Do not give answer
                """, difficulty, type);

        return openAIService.ask(prompt);
    }

    public String evaluate(String question, String answer) {
        String prompt = String.format("""
                You are an interviewer evaluating a candidate.

                Question:
                %s

                Candidate Answer:
                %s

                Evaluate:
                1. Score (0-10)
                2. What is good
                3. What is missing
                4. Ideal answer

                Be strict but fair.
                """, question, answer);

        return openAIService.ask(prompt);
    }
}