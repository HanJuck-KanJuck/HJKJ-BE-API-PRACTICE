package com.kimlaparkgyo.hanjuckkanjuckapitest.service;

import com.kimlaparkgyo.hanjuckkanjuckapitest.dto.LocationRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ApiService {
    private final WebClient webClient;

    public ApiService() {
        this.webClient = WebClient.builder()
                .baseUrl("https://apis.openapi.sk.com")
                .defaultHeader("accept", "application/json")
                .defaultHeader("Content-Type", "application/json")
                .defaultHeader("appkey", "Yu8XTMlIbs7T6ot576zbVaGj8O6UQp3X9SQ4eI3n")
                .build();
    }

    public Mono<String> getPois() {
        return webClient.get()
                .uri("/puzzle/place/meta/pois")
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> getArea() {
        return webClient.get()
                .uri("/puzzle/place/meta/areas")
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> getRealtimePoisCongestion(String poiId, LocationRequest request) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/puzzle/place/congestion/rltm/pois/{poiId}")
                        .queryParam("lng", request.getLng())
                        .queryParam("lat", request.getLat())
                        .build(poiId))
                .retrieve()
                .bodyToMono(String.class);
    }
}
