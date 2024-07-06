package com.literalura.literalura.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MenuController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/buscar-libro")
    public String buscarLibro() {
        return "buscar-libro";
    }

    @GetMapping("/listar-libros")
    public String listarLibros() {
        return "listar-libros";
    }

    @GetMapping("/listar-autores")
    public String listarAutores() {
        return "listar-autores";
    }

    @GetMapping("/listar-autores-vivos")
    public String listarAutoresVivos() {
        return "listar-autores-vivos";
    }

    @GetMapping("/listar-libros-por-idioma")
    public String listarLibrosPorIdioma() {
        return "listar-libros-por-idioma";
    }
}
