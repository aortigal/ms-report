package com.bank.msreport.services.impl;

import com.bank.msreport.models.utils.ResponseTransaction;
import com.bank.msreport.services.TransactionService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final WebClient webClient;

    public TransactionServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl("http://localhost:8086").build();
    }

    @Override
    public Mono<ResponseTransaction> findByIdClient(String id) {
        return webClient.get()
                .uri("/api/transaction/clientTransactions/"+ id)
                .retrieve()
                .bodyToMono(ResponseTransaction.class);
    }
}
