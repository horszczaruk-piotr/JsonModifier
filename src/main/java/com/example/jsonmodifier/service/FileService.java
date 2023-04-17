package com.example.jsonmodifier.service;

import com.example.jsonmodifier.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FileService {
    private final JsonConverter jsonConverter;
    private final FileRepository fileRepository;

    public String uploadFile(Map<String, Object> json) throws IOException {
        try {
            String csvData = jsonConverter.convertJsonToCsv(json);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm");
            String fileName = "file_" + LocalDateTime.now().format(formatter) + ".csv";
            fileRepository.saveFile(fileName, csvData);
            return fileName;
        } catch (IOException e) {
            throw new IOException("Uploading error");
        }
    }

}
