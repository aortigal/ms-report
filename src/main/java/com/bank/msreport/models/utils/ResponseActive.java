package com.bank.msreport.models.utils;

import com.bank.msreport.models.documents.Active;
import lombok.Data;

@Data
public class ResponseActive
{
    private Active data;

    private String message;

    private String status;

}
