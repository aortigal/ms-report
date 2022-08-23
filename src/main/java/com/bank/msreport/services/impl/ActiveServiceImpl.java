package com.bank.msreport.services.impl;

import com.bank.msreport.models.utils.ResponseActive;
import com.bank.msreport.models.utils.ResponseActives;
import com.bank.msreport.services.ActiveService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class ActiveServiceImpl implements ActiveService {

    private final WebClient webClient;

    public ActiveServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl("http://localhost:8083").build();
    }

    @Override
    public Mono<ResponseActive> findByCode(String id) {
        return webClient.get()
                .uri("/api/active/"+ id)
                .retrieve()
                .bodyToMono(ResponseActive.class);
    }

    @Override
    public Mono<ResponseActive> activesByClient(String id) {
        return webClient.get()
                .uri("/api/active/client/"+ id)
                .retrieve()
                .bodyToMono(ResponseActive.class);
    }

    @Override
    public Mono<ResponseActives> findAll() {
        return webClient.get()
                .uri("/api/active/")
                .retrieve()
                .bodyToMono(ResponseActives.class);
    }

}
