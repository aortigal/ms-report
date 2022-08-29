package com.bank.msreport.models.documents;

import com.bank.msreport.models.utils.Audit;
import lombok.Data;

@Data
public class Payment extends Audit
{
    private String id;
    private String activeId;
    private String clientId;
    private String creditId;
    private Float amount;
}
