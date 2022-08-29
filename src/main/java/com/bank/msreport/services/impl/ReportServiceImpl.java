package com.bank.msreport.services.impl;

import com.bank.msreport.models.documents.Active;
import com.bank.msreport.models.documents.Pasive;
import com.bank.msreport.models.documents.Transaction;
import com.bank.msreport.models.utils.ResponseCreditCard;
import com.bank.msreport.models.utils.ResponseRange;
import com.bank.msreport.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    private static final Logger log = LoggerFactory.getLogger(ReportServiceImpl.class);

    @Autowired
    private ActiveService activeService;

    @Autowired
    private PasiveService pasiveService;

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
                                responseCreditCard.setAmount(transaction.getAmount());
                                return responseCreditCard;
                            }).collectList();
                }).doFinally(fin -> log.info("[END] movementCreditCard report"));
    }

    @Override
    public Mono<ResponseRange> rangeByProduct(String ini, String end) {
        log.info("[INI] rangeByProduct report");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate localDateIni = LocalDate.parse(ini, formatter);

        LocalDate localDateEnd = LocalDate.parse(end, formatter);

        LocalDateTime localDateTimeIni = LocalDateTime.of(localDateIni, LocalTime.MIN);

        LocalDateTime localDateTimeEnd = LocalDateTime.of(localDateEnd, LocalTime.MAX);

        return activeService.findAll()
                .doOnNext(transaction -> log.info(transaction.toString()))
                .flatMap(response -> {
                    if(response.getData() == null){
                        return Mono.just(null);
                    }

                    List<Active> activeList = response.getData().stream()
                            .filter(active -> active.getDateRegister() !=null && active.getDateRegister().isAfter(localDateTimeIni)
                                    && active.getDateRegister().isBefore(localDateTimeEnd))
                            .collect(Collectors.toList());

                    return pasiveService.findAll()
                            .doOnNext(responsePasives -> log.info(responsePasives.toString()))
                            .flatMap(responsePasives -> {
                                if(responsePasives.getData() == null){
                                    return Mono.just(null);
                                }

                                List<Pasive> pasiveList = responsePasives.getData().stream()
                                        .filter(pasive -> pasive.getCreatedDate() !=null && pasive.getCreatedDate().isAfter(localDateTimeIni)
                                                && pasive.getCreatedDate().isBefore(localDateTimeEnd))
                                        .collect(Collectors.toList());

                                return Mono.just(new ResponseRange(activeList,pasiveList));
                            });
                }).doFinally(fin -> log.info("[END] rangeByProduct report"));

    }
}
