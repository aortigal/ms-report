package com.bank.msreport.models.utils;

import com.bank.msreport.models.documents.Active;
import lombok.Data;

import java.util.List;

@Data
public class ResponseActives {
    private List<Active> data;

    private String message;

    private String status;

}
