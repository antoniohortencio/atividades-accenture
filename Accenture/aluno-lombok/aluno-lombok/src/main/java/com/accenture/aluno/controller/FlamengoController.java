package com.accenture.aluno.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flamengo")
public class FlamengoController {

    @GetMapping
    public ResponseEntity<String> flamengo() {
        return ResponseEntity.ok("Mengão! 🔴⚫");
    }
}
