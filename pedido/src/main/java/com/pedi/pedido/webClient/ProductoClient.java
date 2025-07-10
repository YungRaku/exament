package com.pedi.pedido.webClient;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Value;
import java.util.Map;

public class ProductoClient {
    private final WebClient webcliente;

    @Value("${producto-service.url}")
    private String productoServiceUrl;

    public ProductoClient(@Value("${producto-service.url}") String productoServiceUrl) {
        this.webcliente = WebClient.builder().baseUrl(productoServiceUrl).build();
    }

    public Map<String, Object> getProductoById(Long id) {
        return this.webcliente.get()
            .uri("/{id}", id)  
            .retrieve()
            .onStatus(status -> status.is4xxClientError(),
                response -> response.bodyToMono(String.class)
                    .map(body -> new RuntimeException("Producto "+id+" no encontrado")))
            .bodyToMono(new org.springframework.core.ParameterizedTypeReference<Map<String, Object>>() {})
            .block(); 
    }

}
