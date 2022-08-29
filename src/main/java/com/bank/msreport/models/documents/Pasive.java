package com.bank.msreport.models.documents;

import com.bank.msreport.models.utils.Audit;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
public class Pasive {

    private String id;
    private String clientId;
    private String pasivesType;

    private Float amount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy",timezone = "GMT-05:00")
    private Date specificDay;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;
}
