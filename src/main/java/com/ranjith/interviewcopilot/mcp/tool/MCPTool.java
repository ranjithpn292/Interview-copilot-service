package com.ranjith.interviewcopilot.mcp.tool;

import java.util.Map;

public interface MCPTool {

    String execute(Map<String, Object> input);

    String getName();
}