package com.ppx.ppxusermgt.dao;

import com.ppx.ppxusermgt.entity.PpxUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<PpxUser, Long> {
    PpxUser findByUserName(String userName);
}
