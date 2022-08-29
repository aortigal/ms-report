package com.bank.msreport.services;

import com.bank.msreport.models.utils.Amount;
import com.bank.msreport.models.utils.ResponseAmount;
import com.bank.msreport.models.utils.ResponseParameter;
import com.bank.msreport.models.utils.ResponsePasives;
import reactor.core.publisher.Mono;

public interface PasiveService {

    Mono<ResponseParameter> getTypeParams(String idPasive);
    Mono<ResponseAmount> getAmount(String idPasive);
    Mono<ResponseAmount> setAmount(String idPasive, Amount amount);
    Mono<ResponsePasives> findAll();
}
