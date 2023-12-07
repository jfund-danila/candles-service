package com.jfund.candlesservice.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
public class CurrencyValue {
    @Field
    private String key;
    @Field
    private Float value;

}
