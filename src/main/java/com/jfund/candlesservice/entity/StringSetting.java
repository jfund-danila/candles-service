package com.jfund.candlesservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document
public class StringSetting {
    @Id
    String key;
    String value;
    @PersistenceCreator
    public StringSetting(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
