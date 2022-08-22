package com.bank.msreport.models.utils;

import com.bank.msreport.models.documents.Transaction;
import lombok.Data;

import java.util.List;

@Data
public class ResponseTransaction
{
    private List<Transaction> data;

    private String message;

    private String status;

}
