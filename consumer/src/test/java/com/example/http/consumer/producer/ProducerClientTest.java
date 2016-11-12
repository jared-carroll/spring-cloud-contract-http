package com.example.http.consumer.producer;

import com.example.http.consumer.producer.ProducerClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureStubRunner(
        ids = "com.example.http.producer:producer:+:6565",
        workOffline = true
)
public class ProducerClientTest {
    @Autowired
    ProducerClient producerClient;

    @Test
    public void getData() {
        List<Integer> data = producerClient.getData();

        assertThat(data).hasSize(3);
        assertThat(data).isEqualTo(asList(15, 150, 35));
    }
}