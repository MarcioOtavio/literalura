package com.alura.literalura.api;

import com.alura.literalura.dto.GutendexResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

@Component
public class GutendexClient {

    private final RestClient restClient;
    private final ObjectMapper objectMapper;

    public GutendexClient(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.restClient = RestClient.builder()
                .baseUrl("https://gutendex.com")
                .build();
    }

    public GutendexResponse buscarLivroPorTitulo(String titulo) {
        try {
            ResponseEntity<String> responseEntity = restClient.get()
                    .uri("/books?search={titulo}", titulo)
                    .retrieve()
                    .toEntity(String.class);

            System.out.println("Status da Resposta da API: " + responseEntity.getStatusCode());
            String jsonBody = responseEntity.getBody();
            System.out.println("Corpo da Resposta da API (JSON Cru): " + jsonBody);

            if (jsonBody == null || jsonBody.isEmpty()) {
                System.err.println("O corpo da resposta da API está vazio ou nulo.");
                return null;
            }

            return objectMapper.readValue(jsonBody, GutendexResponse.class);

        } catch (RestClientException e) {
            System.err.println("Erro de comunicação com a API Gutendex: " + e.getMessage());
            throw new RuntimeException("Erro ao se comunicar com a API Gutendex: " + e.getMessage(), e);
        } catch (Exception e) {
            System.err.println("Erro ao processar a resposta da API: " + e.getMessage());
            throw new RuntimeException("Erro ao processar a resposta da API: " + e.getMessage(), e);
        }
    }
}