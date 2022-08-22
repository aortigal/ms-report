package com.bank.msreport.services.impl;

import com.bank.msreport.models.documents.Transaction;
import com.bank.msreport.models.utils.ResponseCreditCard;
import com.bank.msreport.services.ActiveService;
import com.bank.msreport.services.ClientService;
import com.bank.msreport.services.ReportService;
import com.bank.msreport.services.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    private static final Logger log = LoggerFactory.getLogger(ReportServiceImpl.class);

    @Autowired
    private ActiveService activeService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private TransactionService transactionService;

    @Override
    public Mono<List<ResponseCreditCard>> movementCreditCard(String id) {
        log.info("[INI] movementCreditCard report");
        return transactionService.findByIdClient(id)
                .doOnNext(transaction -> log.info(transaction.toString()))
                .flatMap(response -> {
                    if(response.getData() == null){
                        return Mono.just(null);
                    }
                    List<Transaction> transactionList = response.getData().stream()
                            .sorted(Comparator.comparing(Transaction::getDateRegister).reversed())
                            .limit(10).collect(Collectors.toList());
                    return Flux.fromIterable(transactionList)
                            .doOnNext(transaction -> log.info(transaction.toString()))
                            .map(transaction -> {
                                ResponseCreditCard responseCreditCard = new ResponseCreditCard();
                                responseCreditCard.setDateRegister(transaction.getDateRegister());
                                responseCreditCard.setMovementType("Transaction");
                                responseCreditCard.setMont(transaction.getMont());
                                return responseCreditCard;
                            }).collectList();
                }).doFinally(fin -> log.info("[END] movementCreditCard report"));
    }
}
