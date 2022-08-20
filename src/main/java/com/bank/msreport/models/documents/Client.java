package com.bank.msreport.models.documents;

import com.bank.msreport.models.utils.Audit;
import lombok.Data;

@Data
public class Client extends Audit {
    private String id;
    private String type;
    private String firstname;
    private String lastName;
    private String genre;
    private String documentId;
    private String phoneNumber;
    private String email;
    private Object clientData;

}
