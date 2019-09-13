package com.ppx.admin.web;

import com.ppx.admin.request.UserRequest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminUserControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private AdminUserController adminUserController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(adminUserController).build();
    }


    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void list() {
    }

    @Test
    public void addUser() {
        try {
            UserRequest userRequest = new UserRequest();
            userRequest.setUserName("test");
            userRequest.setPwd("test1");

            mockMvc.perform(MockMvcRequestBuilders.post("/admin/user/add", userRequest))
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}