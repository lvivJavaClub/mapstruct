package com.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Balance {

    private int id;
    private int currencyCode;
    private BigDecimal bookedBalance;
    private Currency currency;
    private LocalDateTime transactionDateTime;

}
