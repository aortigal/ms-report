package com.bank.msreport.models.utils;

import com.bank.msreport.models.documents.Parameter;
import lombok.Data;

import java.util.List;

@Data
public class ResponseParameter
{
    private List<Parameter> data;

    private String message;

    private String status;

}
