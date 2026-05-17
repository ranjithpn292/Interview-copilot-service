package com.ranjith.interviewcopilot.mcp.dto;

import java.util.Map;

public class MCPRequest {

    private String tool;
    private Map<String, Object> input;

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    public Map<String, Object> getInput() {
        return input;
    }

    public void setInput(Map<String, Object> input) {
        this.input = input;
    }
}