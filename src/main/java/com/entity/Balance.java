package com.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Balance {

    private int id;
    private BigDecimal bookedBalance1;
    private BigDecimal bookedBalance2;
    private Day dayEnum;
    private LocalDateTime transactionDateTime;

}
