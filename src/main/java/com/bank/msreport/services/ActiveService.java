package com.bank.msreport.services;

import com.bank.msreport.models.utils.ResponseActive;
import reactor.core.publisher.Mono;

public interface ActiveService {
    Mono<ResponseActive> findByCode(String id);
}
