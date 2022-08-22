package com.bank.msreport.services;

import com.bank.msreport.models.utils.ResponseCreditCard;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ReportService {
    Mono<List<ResponseCreditCard>> movementCreditCard(String id);
}
