package com.ranjith.interviewcopilot.mcp.tool;

import com.ranjith.interviewcopilot.service.OpenAIService;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EvaluateAnswerTool implements MCPTool {

    private final OpenAIService openAIService;

    public EvaluateAnswerTool(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @Override
    public String execute(Map<String, Object> input) {

        String question = input.get("question").toString();
        String answer = input.get("answer").toString();

        String prompt = String.format("""
                    Return ONLY valid JSON.
                    
                    {
                      "score": 0,
                      "strengths": [],
                      "weaknesses": [],
                      "ideal_answer": "..."
                    }
                    
                    Question:
                    %s
                    
                    Candidate Answer:
                    %s
                    """, question, answer);

        return openAIService.ask(prompt);
    }

    @Override
    public String getName() {
        return "evaluate_answer";
    }
}
