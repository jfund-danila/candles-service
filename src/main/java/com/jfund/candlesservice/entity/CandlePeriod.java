package com.jfund.candlesservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "candlePeriods")
public class CandlePeriod {
    @Id
    Long minutes;
    String label;
    @PersistenceCreator
    public CandlePeriod(Long minutes, String label) {
        this.minutes = minutes;
        this.label = label;
    }
}
