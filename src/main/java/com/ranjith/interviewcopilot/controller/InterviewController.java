package com.ranjith.interviewcopilot.controller;

import com.ranjith.interviewcopilot.service.InterviewService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/interview")
public class InterviewController {

    private final InterviewService interviewService;

    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    @GetMapping("/question")
    public String getQuestion(
            @RequestParam String type,
            @RequestParam String difficulty) {

        return interviewService.getQuestion(type, difficulty);
    }

    @PostMapping("/evaluate")
    public String evaluate(
            @RequestParam String question,
            @RequestParam String answer) {

        return interviewService.evaluate(question, answer);
    }
}