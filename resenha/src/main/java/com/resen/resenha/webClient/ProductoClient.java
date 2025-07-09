package com.resen.resenha.webClient;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;


@Component
public class ProductoClient {

    private final WebClient webClient;

    public ProductoClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8083/productos").build();
    }

    public Map<String, Object> getProductoById(Long id) {
        return webClient.get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {})
                .block();
    }
    

}
