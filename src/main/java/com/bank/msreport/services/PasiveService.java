package com.bank.msreport.services;

import com.bank.msreport.models.utils.Mont;
import com.bank.msreport.models.utils.ResponseMont;
import com.bank.msreport.models.utils.ResponseParameter;
import reactor.core.publisher.Mono;

public interface PasiveService {

    Mono<ResponseParameter> getTypeParams(String idPasive);
    Mono<ResponseMont> getMont(String idPasive);
    Mono<ResponseMont> setMont(String idPasive, Mont mont);
}
