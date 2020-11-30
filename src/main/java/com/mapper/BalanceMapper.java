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

    public static BalanceMapper INSTANCE = Mappers.getMapper(BalanceMapper.class);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "dayEnum", source = "externalDayEnum")
    @Mapping(target = "bookedBalanceTest1", source = "bookedBalance", qualifiedByName = {"HALF_UP"})
    @Mapping(target = "bookedBalanceTest2", source = "bookedBalance", dateFormat = "dd-MM-yyyy HH:mm:ss")
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

    @Named("HALF_UP")
    public BigDecimal halfUp(BigDecimal externalDay) {
        return externalDay.setScale(2, RoundingMode.HALF_UP);
    }

}
