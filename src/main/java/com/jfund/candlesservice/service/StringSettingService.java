package com.jfund.candlesservice.service;

import com.jfund.candlesservice.entity.StringSetting;
import com.jfund.candlesservice.repository.StringSettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StringSettingService {
    private StringSettingRepository repository;

    @Autowired
    public void setRepository(StringSettingRepository repository) {
        this.repository = repository;
    }

    public StringSetting put(String key, String value){
        return repository.save(new StringSetting(key, value));
    }

    public Optional<StringSetting> get(String key){
        return repository.findFirstByKey(key);
    }
}
