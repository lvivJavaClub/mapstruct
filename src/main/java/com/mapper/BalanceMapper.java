package com.mapper;

import com.entity.Balance;
import com.entity.Currency;
import com.external.dto.ExternalBalanceDto;
import com.external.dto.ExternalCurrency;
import org.mapstruct.AfterMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BalanceMapper {
    BalanceMapper INSTANCE = Mappers.getMapper(BalanceMapper.class);

    @Mapping(target = "bookedBalance", source = "bookedBalance")
    @Mapping(target = "id", source = "arrangementId")
    @Mapping(target = "transactionDateTime", source = "transactionDate", dateFormat = "dd-MM-yyyy HH:mm:ss")
    Balance map(ExternalBalanceDto externalBalanceDto);

    @Mapping(target = "currencyCode", source = "externalCurrency.externalCode")
    Balance mapWithCurrency(ExternalBalanceDto externalBalanceDto, ExternalCurrency externalCurrency);

    @InheritInverseConfiguration
    ExternalBalanceDto map(Balance externalBalanceDto);

    @Mapping(target = "code", source = "externalCode")
    @Mapping(target = "countryCode", source = "externalCountryCode")
    Currency mapCurrency(ExternalCurrency externalCurrency);

    @AfterMapping
    default void populateBalance(ExternalBalanceDto externalBalanceDto, @MappingTarget Balance balance) {
        balance.setId(2222);
    }

}
