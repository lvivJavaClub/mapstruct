package com.mapper;

import com.entity.Balance;
import com.external.dto.ExternalBalanceDto;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

class BalanceMapperTest {

    @Test
    void map() {
        BalanceMapper mapper = BalanceMapper.INSTANCE;

        LocalDateTime now = LocalDateTime.now();
        ExternalBalanceDto externalBalanceDto = new ExternalBalanceDto();
        externalBalanceDto.setArrangementId("11111");
        externalBalanceDto.setTransactionDate(now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));

        Balance balance = mapper.map(externalBalanceDto);

        Assertions.assertEquals(2222, balance.getId());
//        Assertions.assertEquals(now.toString(), balance.getTransactionDateTime().toString());
    }

}