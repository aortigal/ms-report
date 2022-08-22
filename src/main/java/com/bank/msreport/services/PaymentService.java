package com.bank.msreport.services;

import com.bank.msreport.models.utils.ResponsePayment;
import reactor.core.publisher.Mono;

public interface PaymentService {
    Mono<ResponsePayment> findByIdClient(String id);
}
