package com.ppx.message.ppxusermgt.dao;

import com.ppx.message.ppxusermgt.entity.PpxUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<PpxUser, Long> {
    PpxUser findByUserName(String userName);
}
