package com.literalura.literalura.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class GutendexService {

    private final WebClient webClient;

    public GutendexService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://gutendex.com").build();
    }

    public Mono<GutendexResponse> listBooks() {
        return this.webClient.get()
                .uri("/books")
                .retrieve()
                .bodyToMono(GutendexResponse.class);
    }

    public Mono<GutendexResponse> searchBooksByTitle(String title) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/books")
                        .queryParam("search", title)
                        .build())
                .retrieve()
                .bodyToMono(GutendexResponse.class);
    }

    public Mono<GutendexResponse> listAuthors() {
        return this.webClient.get()
                .uri("/authors")
                .retrieve()
                .bodyToMono(GutendexResponse.class);
    }

    public Mono<GutendexResponse> listLivingAuthors() {
        return this.webClient.get()
                .uri("/authors/living")
                .retrieve()
                .bodyToMono(GutendexResponse.class);
    }

    public Mono<GutendexResponse> listBooksByLanguage(String language) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/books")
                        .queryParam("languages", language)
                        .build())
                .retrieve()
                .bodyToMono(GutendexResponse.class);
    }
}
