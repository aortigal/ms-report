package com.bank.msreport.models.documents;

import com.bank.msreport.models.utils.Audit;
import lombok.Data;

@Data
public class Transaction extends Audit
{
    private String id;
    private String activeId;
    private String clientId;
    private String creditId;
    private float amount;
    private String seller;
    private String ruc;

}
