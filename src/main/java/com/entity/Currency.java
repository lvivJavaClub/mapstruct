package com.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Currency {

    private String code;
    private String countryCode;

}
