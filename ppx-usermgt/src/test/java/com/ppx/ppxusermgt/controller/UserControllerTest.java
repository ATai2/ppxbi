package com.ppx.ppxusermgt.controller;

import com.ppx.ppxusermgt.entity.PpxUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    private MockMvc mvc;
    @Autowired
    UserController userController;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void getHello() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/user/users").accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn();
    }

    @Test
    public void addTest(){
        List<PpxUser> list=new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            PpxUser user=new PpxUser();
            user.setUserId(i);
            user.setUserName("user" + i);
            user.setPwd("pwd"+i);
            user.setRole("admin");
            list.add(user);
        }
            userController.createUser(list);



    }
}
