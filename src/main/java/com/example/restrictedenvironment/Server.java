package com.example.restrictedenvironment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * A REST API for the jail environment
 *
 * @author Fahd Alsahali
 * @version 1.0
 * @date 15/02/2023
 */
@RestController
@RequestMapping("/api")
public class Server {

    /**
     * A method to receive the submission file
     *
     * @param file The submission file
     * @return Responses indicating whether the file was received successfully
     */
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

    /**
     * A method to grade the uploaded submission with a test case
     *
     * @param mainFileName The name of the submission
     * @param testCaseInput The input of the test case
     * @param testCaseOutput The output of the test case
     * @return Responses indicating whether the file passed the test case or not
     */
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
