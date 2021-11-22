package br.com.robot.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    NavigateService service;

    @Test
    void case1(){
        Assertions.assertEquals(service.execute("MMRMMRMM".split("")),"(2, 0, S)");

    }

    @Test
    void case2(){
        Assertions.assertEquals(service.execute("MML".split("")),"(0, 2, W)");
    }

    @Test
    void case3(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            service.execute("MMMMMMMMMMMMMMMMMMMMMMMMM".split(""));
        });
    }

    @Test
    void case4() throws Exception {

        mockMvc.perform(post("/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMMM"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void case5() throws Exception {
        mockMvc.perform(post("/rest/mars/MMRMMRMM"))
                .andExpect(status().isOk());
    }
}
