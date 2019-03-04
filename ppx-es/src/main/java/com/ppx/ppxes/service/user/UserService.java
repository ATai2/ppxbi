package com.ppx.ppxes.service.user;


import com.ppx.ppxes.entity.User;

/**
 * 用户Service接口
 * Created by gegf
 */
public interface UserService {

    User findUserByName(String username);

//    ServiceResult<UserDTO> findById(Long useId);
}
