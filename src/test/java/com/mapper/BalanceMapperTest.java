package com.mapper;

import com.entity.Balance;
import com.external.dto.ExternalBalanceDto;
import com.external.dto.ExternalDay;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BalanceMapperTest {

    @Test
    void mapTest1() {
        BalanceMapper mapper = BalanceMapper.INSTANCE;
        ExternalBalanceDto externalBalanceDto = new ExternalBalanceDto();

        externalBalanceDto.setExternalDayEnum(ExternalDay.MONDAY);

        Balance balance = mapper.map(externalBalanceDto);
        Assertions.assertEquals(null, balance.getDayEnum());

    }

    @Test
    void mapTest2() {
        BalanceMapper mapper = BalanceMapper.INSTANCE;
        ExternalBalanceDto externalBalanceDto = new ExternalBalanceDto();

        LocalDateTime now = LocalDateTime.now();
        externalBalanceDto.setTransactionDate(now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));

        Balance balance = mapper.map(externalBalanceDto);
        Assertions.assertEquals(now.toString(), balance.getTransactionDateTime().toString());

    }

}