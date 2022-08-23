package com.bank.msreport.models.utils;

import com.bank.msreport.models.documents.Active;
import com.bank.msreport.models.documents.Pasive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseRange {

    private List<Active> actives;

    private List<Pasive> pasives;
}
