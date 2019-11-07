package com.ppx.soufang.repository;

import com.ppx.soufang.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 角色数据DAO
 * Created by 瓦力.
 */
public interface RoleRepository extends CrudRepository<Role, Long> {

    List<Role> findRolesByUserId(Long userId);

}
