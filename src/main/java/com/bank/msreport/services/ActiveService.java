package com.bank.msreport.services;

import com.bank.msreport.models.utils.ResponseActive;
import com.bank.msreport.models.utils.ResponseActives;
import reactor.core.publisher.Mono;

public interface ActiveService {
    Mono<ResponseActive> findByCode(String id);

    Mono<ResponseActive> activesByClient(String id);

    Mono<ResponseActives> findAll();
}
