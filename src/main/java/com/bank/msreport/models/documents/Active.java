package com.bank.msreport.models.documents;

import com.bank.msreport.models.utils.Audit;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Active {
    private String id;
    private String clientId;
    private String activeType;
    private List<Credit> credits;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateRegister;
}
