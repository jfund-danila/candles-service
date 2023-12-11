package com.jfund.candlesservice.repository;

import com.jfund.candlesservice.entity.StringSetting;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StringSettingRepository extends MongoRepository<StringSetting, String> {
    Optional<StringSetting> findFirstByKey(String key);
}
