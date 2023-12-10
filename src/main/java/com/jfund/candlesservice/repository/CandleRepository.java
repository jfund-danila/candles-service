package com.jfund.candlesservice.repository;

import com.jfund.candlesservice.entity.Candle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandleRepository extends MongoRepository<Candle, Long> {
}
