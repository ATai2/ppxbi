package com.ppx.ppxes.repository;

import com.ppx.ppxes.PpxEsApplicationTests;
import com.ppx.ppxes.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.Assert.*;


public class UserRepositoryTest extends PpxEsApplicationTests {
    @Autowired
    private UserRepository userRepository;
    @Test
    public void testFindOne(){
        Optional<User> user = userRepository.findById(1L);
        assertEquals("a",user.get().getName());
    }

}