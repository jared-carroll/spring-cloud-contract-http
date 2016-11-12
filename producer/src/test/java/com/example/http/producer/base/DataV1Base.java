package com.example.http.producer.base;

import com.example.http.producer.data.DataController;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class DataV1Base {
    @Before
    public void setUp() {
        RestAssuredMockMvc.standaloneSetup(new DataController());
    }
}