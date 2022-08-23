package com.bank.msreport.models.utils;

import com.bank.msreport.models.documents.Pasive;
import lombok.Data;

import java.util.List;

@Data
public class ResponsePasives {
    private List<Pasive> data;

    private String message;

    private String status;
}
