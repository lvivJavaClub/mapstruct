package com.mapper;

import com.entity.Balance;
import com.external.dto.ExternalBalanceDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BalanceMapper {
    BalanceMapper INSTANCE = Mappers.getMapper(BalanceMapper.class);

    @Mapping(target = "bookedBalance", source = "bookedBalance")
    Balance map(ExternalBalanceDto externalBalanceDto);

}
