package com.beeinstant.micrometer.controller;

import com.beeinstant.micrometer.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleControllerTest {
    @Autowired
    private WebTestClient webClient;

    @Test
    public void exampleTest() {
//        for (int i = 0; i < Integer.MAX_VALUE; i ++) {
            this.webClient.get().uri("/greeting?name="+"metrics_"+0).exchange().expectStatus().isOk();
//        }
    }
}