package com.ppx.learn.dao;


import com.ppx.learn.domain.ActorEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ActorMapper {
    @Select("SELECT * FROM actor WHERE actor_id = #{actor_id}")
    @Options(keyProperty="actor_id",keyColumn="actor_id",useGeneratedKeys=true)
    ActorEntity getActor(@Param("actor_id") Integer actor_id);
}