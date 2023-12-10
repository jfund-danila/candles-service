package com.jfund.candlesservice.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Candle {
    @Id
    Long id;

    @Indexed
    String key;

    @Indexed
    Long periodMinutes;

    float minValue, maxValue, startValue, endValue;

    LocalDateTime startActualTime;
    LocalDateTime endActualTime;

    LocalDateTime created = LocalDateTime.now();
    LocalDateTime updated = LocalDateTime.now();

    int aggregationValuesCount = 0;

    boolean isValid = false;
    @PersistenceCreator
    public Candle(Long id, String key, Long periodMinutes,
                  float minValue, float maxValue, float startValue, float endValue,
                  LocalDateTime startActualTime, LocalDateTime endActualTime, LocalDateTime created, LocalDateTime updated,
                  int aggregationValuesCount, boolean isValid) {
        this.id = id;
        this.key = key;
        this.periodMinutes = periodMinutes;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.startValue = startValue;
        this.endValue = endValue;
        this.startActualTime = startActualTime;
        this.endActualTime = endActualTime;
        this.created = created;
        this.updated = updated;
        this.aggregationValuesCount = aggregationValuesCount;
        this.isValid = isValid;
    }

    public Candle(String key, Long periodMinutes, LocalDateTime startActualTime) {
        this.key = key;
        this.periodMinutes = periodMinutes;
        this.startActualTime = startActualTime;
    }

    public boolean getIsValid(){
        return aggregationValuesCount > 10;
    }
}
