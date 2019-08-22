package com.ppx.dao;

import com.ppx.api.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberDao {
    @Select("select id,username,password,phone,email,created,updated from mb_user")
    UserEntity findByID(@Param("userId") Long userId);

    @Insert("insert into mb_user (username,password,phone,email,created,updated) values(#{username},#{password},#{phone},#{email},#{created},#{updated})")
    Integer insertUser(UserEntity userEntity);
}
