package com.ppx.ppxes.repository;

import com.ppx.ppxes.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 */
@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    /**
     * 通过用户名查询用户
     * @param username
     * @return
     */
    User findByName(String username);
}
