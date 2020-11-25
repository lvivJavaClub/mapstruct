package com.external.dto;

import java.math.BigDecimal;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExternalBalanceDto {

    private String arrangementId;
    private BigDecimal bookedBalance;

}
