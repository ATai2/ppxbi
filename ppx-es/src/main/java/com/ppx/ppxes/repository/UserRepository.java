package com.ppx.ppxes.repository;

import com.ppx.ppxes.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Administrator
 */
public interface UserRepository extends CrudRepository<User,Long> {
}
