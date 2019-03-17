package com.beeinstant.micrometer;

import com.beeinstant.micrometer.service.MetricsPublisher;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    @Bean
    public MeterRegistry registry() {
        return new SimpleMeterRegistry();
    }

    @Bean
    public MetricsPublisher metricsPublisher() {
        return new MetricsPublisher();
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
