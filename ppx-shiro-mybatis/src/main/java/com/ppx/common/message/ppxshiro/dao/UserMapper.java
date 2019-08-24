package com.ppx.common.message.ppxshiro.dao;

import com.ppx.common.message.ppxshiro.domain.User;
import org.apache.ibatis.annotations.Select;

/**
 * @功能描述：TODO
 * @创建日期: 2019/2/22 20:24
 */
public interface UserMapper {
    @Select("select * from user where name = #{name}")
    public User findByName(String name);

    @Select("select * from user where id = #{id}")
    public User findById(Integer id);
}
