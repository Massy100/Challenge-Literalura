package com.literalura.literalura.clients;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class GutendexClient {

    private final WebClient webClient;

    public GutendexClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://gutendex.com/").build();
    }

    public Mono<String> searchBooksByTitle(String title) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/books")
                        .queryParam("search", title)
                        .build())
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> listBooks() {
        return this.webClient.get()
                .uri("/books")
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> listBooksByLanguage(String language) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/books")
                        .queryParam("languages", language)
                        .build())
                .retrieve()
                .bodyToMono(String.class);
    }
}
