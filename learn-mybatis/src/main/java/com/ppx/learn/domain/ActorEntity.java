package com.ppx.learn.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class ActorEntity {
    private Integer actor_id;
    private String first_name;
    private String last_name;
    private Date last_update;
}
