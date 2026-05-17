package com.ranjith.interviewcopilot.mcp.dto;

public class MCPResponse {

    private boolean success;
    private Object data;

    public MCPResponse(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public Object getData() {
        return data;
    }
}