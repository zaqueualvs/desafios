package com.alves.saudeapi.adapter.in.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/customers")
@RequiredArgsConstructor
public class CustomerController {

    @GetMapping
    public ResponseEntity<String> ola() {
        return ResponseEntity.ok("Ola");
    }
}
