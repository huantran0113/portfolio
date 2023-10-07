package com.example;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class Controller {

    @PostMapping("/data")
    public ResponseEntity<String> processData(@RequestBody Information data) {
        String email = data.getEmail();
        String name = data.getName();
        String message = data.getMessage();

        System.out.println("Email: " + email);
        System.out.println("Name: " + name);
        System.out.println("Message: " + message);

        return ResponseEntity.ok("{\"status\": \"success\", \"message\": \"Data received successfully!\"}");
    }
}
