package com.example.jsonmodifier.controller;

import com.example.jsonmodifier.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;


    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestBody List<Object> jsonList) {
        System.out.println(jsonList.toString());
        try {
            List<Map<String, Object>> json = jsonList;
            final String fileName = fileService.uploadFile(jsonList);
            return new ResponseEntity<>("Plik " + fileName + " został zapisany na dysku.", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Wystąpił błąd podczas zapisywania pliku na dysku.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}