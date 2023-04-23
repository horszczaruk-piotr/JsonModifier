package com.example.jsonmodifier.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class JsonConverter {
    public String convertJsonToCsv(List<Map<String, Object>> jsonList) throws IOException {
        StringBuilder csvBuilder = new StringBuilder();

        String header = jsonList.get(0).keySet().stream().collect(Collectors.joining(","));
        csvBuilder.append(header).append("\n");
        jsonList.stream().map(json -> json.values().stream().map(Object::toString).collect(Collectors.joining(",")))
                .forEach(row -> csvBuilder.append(row).append("\n"));

        return csvBuilder.toString();
    }
}
