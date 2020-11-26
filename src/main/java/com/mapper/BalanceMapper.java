package com.mapper;

import com.entity.Balance;
import com.entity.Day;
import com.external.dto.ExternalBalanceDto;
import com.external.dto.ExternalDay;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BalanceMapper {
    BalanceMapper INSTANCE = Mappers.getMapper(BalanceMapper.class);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "dayEnum", source = "externalDayEnum")
    @Mapping(target = "transactionDateTime", source = "transactionDate", dateFormat = "dd-MM-yyyy HH:mm:ss")
    Balance map(ExternalBalanceDto externalBalanceDto);

    @ValueMapping(source = "MONDAY", target = "MONDAY")
    @ValueMapping(source = MappingConstants.ANY_UNMAPPED, target = MappingConstants.NULL)
    Day map(ExternalDay externalDay);

}
