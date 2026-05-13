package com.ranjith.interviewcopilot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@Service
public class OpenAIService {

    @Value("${openai.api.key}")
    private String apiKey;

    @Value("${openai.url}")
    private String apiUrl;

    private final WebClient webClient;

    public OpenAIService(WebClient.Builder builder) {
        this.webClient = builder.build();
    }

    public String ask(String prompt) {

        Map<String, Object> body = new HashMap<>();
        body.put("model", "gpt-4o-mini");

        List<Map<String, String>> messages = List.of(
                Map.of("role", "user", "content", prompt)
        );

        body.put("messages", messages);

        Map response = webClient.post()
                .uri(apiUrl)
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .bodyValue(body)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        List choices = (List) response.get("choices");
        Map first = (Map) choices.get(0);
        Map message = (Map) first.get("message");

        return message.get("content").toString();
    }
}