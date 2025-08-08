package com.alura.literalura.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/entities")
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Literalura API está rodando!";
    }
}
