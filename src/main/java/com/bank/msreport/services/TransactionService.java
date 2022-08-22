package com.bank.msreport.services;

import com.bank.msreport.models.utils.ResponseTransaction;
import reactor.core.publisher.Mono;

public interface TransactionService {
    Mono<ResponseTransaction> findByIdClient(String id);
}
