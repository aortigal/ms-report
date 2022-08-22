package com.bank.msreport.services.impl;

import com.bank.msreport.models.utils.ResponsePayment;
import com.bank.msreport.services.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final WebClient webClient;

    public PaymentServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl("http://localhost:8085").build();
    }

    @Override
    public Mono<ResponsePayment> findByIdClient(String id) {
        return webClient.get()
                .uri("/api/payment/clientPayments/"+ id)
                .retrieve()
                .bodyToMono(ResponsePayment.class);
    }
}
