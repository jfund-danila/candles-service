package com.jfund.candlesservice.service;

import com.jfund.candlesservice.entity.Candle;
import com.jfund.candlesservice.repository.CandleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CandleService {
    private CandleRepository candleRepository;

    @Autowired
    public void setCandleRepository(CandleRepository candleRepository) {
        this.candleRepository = candleRepository;
    }

    public CompletableFuture<List<Candle>> saveAll(Collection<Candle> candles){
        return CompletableFuture.supplyAsync(() -> candleRepository.saveAll(candles));
    }
}
