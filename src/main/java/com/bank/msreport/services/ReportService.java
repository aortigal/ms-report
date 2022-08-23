package com.bank.msreport.services;

import com.bank.msreport.models.utils.ResponseCreditCard;
import com.bank.msreport.models.utils.ResponseRange;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ReportService {
    Mono<List<ResponseCreditCard>> movementCreditCard(String id);

    Mono<ResponseRange> rangeByProduct(String ini, String end);

}
