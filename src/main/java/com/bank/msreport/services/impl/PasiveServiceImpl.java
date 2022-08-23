package com.bank.msreport.services.impl;

import com.bank.msreport.models.utils.*;
import com.bank.msreport.services.PasiveService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class PasiveServiceImpl implements PasiveService {

    private final WebClient webClient;

    public PasiveServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl("http://localhost:8082").build();
    }

    @Override
    public Mono<ResponseParameter> getTypeParams(String idPasive)
    {
        return webClient.get()
                .uri("/api/pasive/type/"+ idPasive)
                .retrieve()
                .bodyToMono(ResponseParameter.class);
    }

    @Override
    public Mono<ResponseMont> getMont(String idPasive) {
        return webClient.get()
                .uri("/api/pasive/mont/"+ idPasive)
                .retrieve()
                .bodyToMono(ResponseMont.class);
    }

    @Override
    public Mono<ResponseMont> setMont(String idPasive, Mont mont) {
        return webClient.post()
                .uri("/api/pasive/mont/"+ idPasive)
                .body(Mono.just(mont), Mont.class)
                .retrieve()
                .bodyToMono(ResponseMont.class);
    }

    @Override
    public Mono<ResponsePasives> findAll() {
        return webClient.get()
                .uri("/api/pasive/")
                .retrieve()
                .bodyToMono(ResponsePasives.class);
    }
}