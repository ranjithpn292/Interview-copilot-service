package com.ranjith.interviewcopilot.mcp.registry;

import com.ranjith.interviewcopilot.mcp.tool.MCPTool;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ToolRegistry {

    private final Map<String, MCPTool> tools = new HashMap<>();

    public ToolRegistry(List<MCPTool> toolList) {
        for (MCPTool tool : toolList) {
            tools.put(tool.getName(), tool);
        }
    }

    public MCPTool getTool(String toolName) {
        return tools.get(toolName);
    }
}