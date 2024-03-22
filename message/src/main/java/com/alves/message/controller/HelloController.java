package com.alves.message.controller;

import com.alves.message.produce.HelloProduce;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
@RequiredArgsConstructor
public class HelloController {

    private final HelloProduce helloProduce;

    @GetMapping("/hello/{name}")
    public ResponseEntity<String> hello(@PathVariable String name) {
        helloProduce.sendMessage("Olá," + name);
        return ResponseEntity.ok().body("OK");
    }
}
