package com.example.jsonmodifier.repository;

import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Repository
public class FileRepository {
    private static final String FILE_UPLOAD_PATH = "C:\\Users\\piotr\\Documents\\";

    public void saveFile(String fileName, String csvData) throws IOException {
        File newFile = new File(FILE_UPLOAD_PATH + fileName);
        Files.write(newFile.toPath(), csvData.getBytes());
    }
}
