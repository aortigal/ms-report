package com.bank.msreport.models.documents;

import com.bank.msreport.models.utils.Audit;
import lombok.Data;
import java.util.List;

@Data
public class Active extends Audit {
    private String id;
    private String clientId;
    private int activeType;
    private List<Credit> credits;
}
