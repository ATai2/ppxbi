package com.ppx.ppxorder.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class FilmInfo {
    private Long id;
    private String filmName;
    private String desp;
    private List<String> actors;
    private List<String> directors;
//    private List<>
}
