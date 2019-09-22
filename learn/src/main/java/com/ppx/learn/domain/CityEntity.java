package com.ppx.learn.domain;

import com.ppx.learn.anno.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(value = "city")
public class CityEntity {
    private String id;
    private String name;
}
