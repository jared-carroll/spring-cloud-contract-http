package com.example.http.consumer.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ProducerClient {
    private RestTemplate restTemplate;

    public ProducerClient(RestTemplateBuilder restTemplateBuilder,
                          @Value("${producer-root-uri}") String producerRootUri) {
        this.restTemplate = restTemplateBuilder
                .rootUri(producerRootUri)
                .build();
    }

    public List<Integer> getData() {
        return restTemplate
                .getForObject("/data", GetDataApiResponse.class)
                .getData();
    }

    public static class GetDataApiResponse {
        private List<Integer> data;

        public List<Integer> getData() {
            return data;
        }

        public void setData(List<Integer> data) {
            this.data = data;
        }
    }
}
