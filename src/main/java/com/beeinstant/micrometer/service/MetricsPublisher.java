package com.beeinstant.micrometer.service;

import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MetricsPublisher implements InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(MetricsPublisher.class);
    @Autowired
    private MeterRegistry meterRegistry;

    @Override
    public void afterPropertiesSet() throws Exception {
        Random random = new Random();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            while (true) {
                logger.info("publish metrics");
                try {
                    Thread.sleep(random.nextInt(10000));
                    meterRegistry.counter("MultipleDimensionCounter", "application", "SpringBoot", "demo", "Momo").increment();
                    meterRegistry.counter("SimpleCounter", "demo", "Momo").increment();
                } catch (Throwable e) {
                    logger.error("fail to publish", e);
                }
            }
        });

    }
}
