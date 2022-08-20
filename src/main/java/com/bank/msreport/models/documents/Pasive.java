package com.bank.msreport.models.documents;

import com.bank.msreport.models.utils.Audit;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
public class Pasive extends Audit {

    private String id;
    private String clientId;
    private int pasivesType;

    private Float mont;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy",timezone = "GMT-05:00")
    private Date specificDay;
}
