package com.alura.literalura.model;

import jakarta.persistence.*;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private String idioma;
    private Integer numeroDownloads;

    public Livro() {}

    public Livro(String titulo, String autor, String idioma, Integer numeroDownloads) {
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.numeroDownloads = numeroDownloads;
    }

    public void setTitulo(String title) {
    }

    public void setAutor(String name) {
    }

    public void setIdioma(String s) {
    }

    // getters e setters
}
