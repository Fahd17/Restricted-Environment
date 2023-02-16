package com.example.restrictedenvironment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class Server {

    @GetMapping
    public String findAllUsers() {

        return "Heyyyyyy";
    }

    @PostMapping
    public ResponseEntity<String> uploadFile(@RequestPart("file") MultipartFile file) {

        if (null == file.getOriginalFilename()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get( "./" + file.getOriginalFilename());
            Files.write(path, bytes);
            System.out.println(path.getFileName());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>("File uploaded successfully!", HttpStatus.OK);
    }

    @GetMapping("/grade")
    public ResponseEntity<Boolean> grade(@RequestParam(value = "name")  String mainFileName,
                                         @RequestParam(value = "testCaseInput")  String testCaseInput,
                                         @RequestParam(value = "testCaseOutput")  String testCaseOutput){

        System.out.println(mainFileName);
        JavaGrader javaGrader = new JavaGrader();
        boolean result = javaGrader.gradeProgram(mainFileName, testCaseInput, testCaseOutput);

        if (result) {
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.OK);
        }

    }




}
