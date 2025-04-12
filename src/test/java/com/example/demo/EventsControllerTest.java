package com.example.demo;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class EventsControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void receiveEvent() throws Exception {

        String eventJson = """
            {
                "id": "1",
                "type": "example",
                "source": "test",
                "data": "sample data",
                "time": "2023-01-01T00:00:00Z"
            }
        """;
        mvc.perform(MockMvcRequestBuilders.post("/event")
                .contentType(MediaType.APPLICATION_JSON)
                .content(eventJson))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Event received successfully!")));
    }
}