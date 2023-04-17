package com.example.jsonmodifier.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class JsonConverter {
    public String convertJsonToCsv(Map<String, Object> json) throws IOException {
        // Konwersja obiektu JSON na format CSV
        ObjectMapper objectMapper = new ObjectMapper();
        String csvData = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
        return csvData;
    }
}
