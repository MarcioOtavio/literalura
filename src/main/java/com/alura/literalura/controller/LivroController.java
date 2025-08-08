package com.alura.literalura.controller;

import com.alura.literalura.model.Livro;
import com.alura.literalura.service.LivroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @GetMapping("/livros")
    public List<Livro> listarTodos() {
        // CORREÇÃO: O nome correto do método é "listarLivros"
        return service.listarLivros();
    }

    @PostMapping("/livros")
    public Livro adicionarLivro(@RequestParam String titulo) {
        // CORREÇÃO: O nome correto do método é "buscarEsalvarLivroPorTitulo"
        return service.buscarEsalvarLivroPorTitulo(titulo);
    }
}