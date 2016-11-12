package com.example.http.producer.data;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Arrays.asList;

@RestController
public class DataController {
    @GetMapping("/data")
    public GetDataApiResponse index() {
        GetDataApiResponse getDataApiResponse = new GetDataApiResponse();
        getDataApiResponse.setData(asList(15, 150, 35));
        return getDataApiResponse;
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
