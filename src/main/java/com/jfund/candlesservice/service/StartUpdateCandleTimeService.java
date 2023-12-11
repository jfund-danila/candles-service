package com.jfund.candlesservice.service;

import com.jfund.candlesservice.entity.StringSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class StartUpdateCandleTimeService {
    private final String key = "startTime";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private StringSettingService stringSettingService;

    @Autowired
    public void setStringSettingService(StringSettingService stringSettingService) {
        this.stringSettingService = stringSettingService;
    }

    public void save(LocalDateTime startTime){
        stringSettingService.put(this.key, startTime.format(this.formatter));
    }

    public LocalDateTime get(){
        Optional<StringSetting> settingOptional = stringSettingService.get(this.key);
        if(settingOptional.isPresent())
            return LocalDateTime.parse(settingOptional.get().getValue(), this.formatter);
        else throw new NoSuchElementException("not found start update candle data time!");
    }
}
