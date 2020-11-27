package com.mapper;

import com.entity.Balance;
import com.entity.Day;
import com.external.dto.ExternalBalanceDto;
import com.external.dto.ExternalDay;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = MappingConstants.class)
public abstract class BalanceMapper {

    BalanceMapper INSTANCE = Mappers.getMapper(BalanceMapper.class);

    private Object test;

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "dayEnum", source = "externalDayEnum", defaultExpression = "java(test.testCase())")
    @Mapping(target = "bookedBalance1", source = "bookedBalance1", qualifiedByName = {"MappingConstants", "enumMapping1" })
    @Mapping(target = "bookedBalance2", source = "bookedBalance2", dateFormat = "dd-MM-yyyy HH:mm:ss")
    public abstract Balance map(ExternalBalanceDto externalBalanceDto);

    @ValueMapping(source = "MONDAY", target = "MONDAY")
    @ValueMapping(source = MappingConstants.ANY_UNMAPPED, target = MappingConstants.NULL)
    abstract Day map(ExternalDay externalDay);

    @Named("enumMapping")
    public Day enumMapping(ExternalDay externalDay) {
        if (ExternalDay.FRIDAY == externalDay) {
            throw new RuntimeException("");
        }
        return Day.valueOf(externalDay.toString());
    }

    @Named("enumMapping1")
    public BigDecimal enumMapping1(BigDecimal externalDay) {
        return externalDay;
    }
    @Named("enumMapping2")
    public BigDecimal enumMapping2(BigDecimal externalDay) {
        return externalDay;
    }

    public void setTest(Object test) {
        this.test = test;
    }

}
