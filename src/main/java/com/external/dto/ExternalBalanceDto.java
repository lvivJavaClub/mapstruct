package com.external.dto;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExternalBalanceDto {

    private String arrangementId;
    private BigDecimal bookedBalance;
    private ExternalCurrency currency;
    private String transactionDate;

}
