package com.bank.msreport.controllers;

import com.bank.msreport.models.utils.ResponseCreditCard;
import com.bank.msreport.models.utils.ResponseRange;
import com.bank.msreport.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/report")
public class ReportRestController{

    @Autowired
    private ReportService reportService;

    @GetMapping("/movement/credit-card/{id}")
    public Mono<List<ResponseCreditCard>> movementCreditCard(@PathVariable("id") String id) {
        return reportService.movementCreditCard(id);
    }

    @GetMapping("/range")
    public Mono<ResponseRange> rangeByProduct(@Validated @RequestParam("ini") String ini,@Validated @RequestParam("end") String end) {
        return reportService.rangeByProduct(ini, end);
    }
}
