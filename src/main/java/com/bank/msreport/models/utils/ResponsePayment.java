package com.bank.msreport.models.utils;

import com.bank.msreport.models.documents.Payment;
import lombok.Data;

import java.util.List;

@Data
public class ResponsePayment
{
    private List<Payment> data;

    private String message;

    private String status;

}
