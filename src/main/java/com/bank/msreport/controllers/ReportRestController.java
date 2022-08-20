package com.bank.msreport.controllers;

import com.bank.msreport.models.utils.ResponseCreditCard;
import com.bank.msreport.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/report")
public class ReportRestController{

    @Autowired
    private ReportService reportService;

    @GetMapping("movement/credit-card")
    public Mono<ResponseCreditCard> movementCreditCard() {
        return Mono.just(new ResponseCreditCard());
    }
}
