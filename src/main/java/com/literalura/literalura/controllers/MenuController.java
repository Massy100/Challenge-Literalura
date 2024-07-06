package com.literalura.literalura.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.literalura.literalura.services.GutendexResponse;
import com.literalura.literalura.services.GutendexService;

import reactor.core.publisher.Mono;

@Controller
public class MenuController {

    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private GutendexService gutendexService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/buscar-libro")
    public Mono<String> buscarLibroPorTitulo(@RequestParam("titulo") String titulo, Model model) {
        return gutendexService.searchBooksByTitle(titulo)
                .map(response -> {
                    GutendexResponse gutendexResponse = new Gson().fromJson(response, GutendexResponse.class);
                    model.addAttribute("books", gutendexResponse.getResults());
                    return "buscar-libro";
                })
                .doOnError(error -> {
                    model.addAttribute("error", error.getMessage());
                    logger.error("Error al buscar libro por título", error);
                })
                .onErrorResume(error -> Mono.just("buscar-libro")); 
    }

    @GetMapping("/listar-libros")
    public Mono<String> listarLibros(Model model) {
        return gutendexService.listBooks()
                .map(response -> {
                    GutendexResponse gutendexResponse = new Gson().fromJson(response, GutendexResponse.class);
                    model.addAttribute("books", gutendexResponse.getResults());
                    return "listar-libros";
                })
                .doOnError(error -> {
                    model.addAttribute("error", error.getMessage());
                    logger.error("Error al obtener libros", error);
                })
                .onErrorResume(error -> Mono.just("listar-libros")); 
    }

    @GetMapping("/listar-autores")
    public Mono<String> listarAutores(Model model) {
        return gutendexService.listAuthors()
                .map(response -> {
                    GutendexResponse gutendexResponse = new Gson().fromJson(response, GutendexResponse.class);
                    model.addAttribute("authors", gutendexResponse.getResults());
                    return "listar-autores";
                })
                .doOnError(error -> {
                    model.addAttribute("error", error.getMessage());
                    logger.error("Error al obtener lista de autores", error);
                })
                .onErrorResume(error -> Mono.just("listar-autores")); 
    }

    @GetMapping("/listar-autores-vivos")
    public Mono<String> listarAutoresVivos(Model model) {
        return gutendexService.listLivingAuthors()
                .map(response -> {
                    GutendexResponse gutendexResponse = new Gson().fromJson(response, GutendexResponse.class);
                    model.addAttribute("livingAuthors", gutendexResponse.getResults());
                    return "listar-autores-vivos";
                })
                .doOnError(error -> {
                    model.addAttribute("error", error.getMessage());
                    logger.error("Error al obtener lista de autores vivos", error);
                })
                .onErrorResume(error -> Mono.just("listar-autores-vivos")); 
    }

    @PostMapping("/listar-libros-por-idioma")
    public Mono<String> listarLibrosPorIdioma(@RequestParam("idioma") String idioma, Model model) {
        return gutendexService.listBooksByLanguage(idioma)
                .map(response -> {
                    GutendexResponse gutendexResponse = new Gson().fromJson(response, GutendexResponse.class);
                    model.addAttribute("books", gutendexResponse.getResults());
                    return "listar-libros-por-idioma";
                })
                .doOnError(error -> {
                    model.addAttribute("error", error.getMessage());
                    logger.error("Error al obtener lista de libros por idioma", error);
                })
                .onErrorResume(error -> Mono.just("listar-libros-por-idioma")); 
    }
}
