package com.ranjith.interviewcopilot.mcp.tool;

import com.ranjith.interviewcopilot.service.OpenAIService;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GenerateQuestionTool implements MCPTool {

    private final OpenAIService openAIService;

    public GenerateQuestionTool(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @Override
    public String execute(Map<String, Object> input) {

        String type = input.get("type").toString();
        String difficulty = input.get("difficulty").toString();

        String prompt = String.format("""
                            Return ONLY valid JSON.
                            
                            {
                              "question": "...",
                              "topic": "...",
                              "difficulty": "%s",
                              "hints": []
                            }
                            
                            Generate ONE %s interview question.
                            """, difficulty, type);

        return openAIService.ask(prompt);
    }

    @Override
    public String getName() {
        return "generate_question";
    }
}