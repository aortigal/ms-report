package com.bank.msreport.services;

import com.bank.mstransaction.models.utils.ResponseActive;
import reactor.core.publisher.Mono;

public interface ActiveService {
    Mono<ResponseActive> findByCode(String id);
}
