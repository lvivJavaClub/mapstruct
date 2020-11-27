package com.external.dto;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExternalBalanceDto {

    private String arrangementId;
    private BigDecimal bookedBalance1;
    private BigDecimal bookedBalance2;
    private ExternalDay externalDayEnum;
    private String transactionDate;

}
