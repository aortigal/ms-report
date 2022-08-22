package com.bank.msreport.models.utils;

import com.bank.msreport.models.documents.Client;
import lombok.Data;

@Data
public class ResponseClient
{
    private Client data;

    private String message;

    private String status;

}
