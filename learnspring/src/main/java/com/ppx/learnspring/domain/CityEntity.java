package com.ppx.learnspring.domain;

import com.ppx.learnspring.anno.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(value = "city")
public class CityEntity {
    private String id;
    private String name;
}
