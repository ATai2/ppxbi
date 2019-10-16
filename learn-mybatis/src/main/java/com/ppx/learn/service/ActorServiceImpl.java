package com.ppx.learn.service;

import com.ppx.learn.dao.ActorMapper;
import com.ppx.learn.domain.ActorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorServiceImpl implements ActorService {
    @Autowired
    private ActorMapper actorMapper;


    public ActorEntity getActor(Integer id) {
        return actorMapper.getActor(id);
    }
}
