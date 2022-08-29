package com.bank.msreport.models.utils;

import lombok.Data;

@Data
public class ResponseAmount
{
    private Amount data;

    private String message;

    private String status;

}
