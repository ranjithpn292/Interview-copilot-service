package com.ranjith.interviewcopilot.mcp.controller;

import com.ranjith.interviewcopilot.mcp.dto.MCPRequest;
import com.ranjith.interviewcopilot.mcp.dto.MCPResponse;
import com.ranjith.interviewcopilot.mcp.registry.ToolRegistry;
import com.ranjith.interviewcopilot.mcp.tool.MCPTool;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mcp")
public class MCPController {

    private final ToolRegistry toolRegistry;

    public MCPController(ToolRegistry toolRegistry) {
        this.toolRegistry = toolRegistry;
    }

    @PostMapping
    public MCPResponse execute(@RequestBody MCPRequest request) {

        MCPTool tool = toolRegistry.getTool(request.getTool());

        if (tool == null) {
            return new MCPResponse(false, "Tool not found");
        }

        String result = tool.execute(request.getInput());

        return new MCPResponse(true, result);
    }
}
