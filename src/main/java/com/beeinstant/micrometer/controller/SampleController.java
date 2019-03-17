package com.beeinstant.micrometer.controller;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class SampleController {

    @Autowired
    private MeterRegistry meterRegistry;

    @RequestMapping("/greeting")
    public void hello(@RequestParam(value="name") String name) throws UnknownHostException {
        meterRegistry.gauge("receivedRequests." + name, 1);
    }
}
