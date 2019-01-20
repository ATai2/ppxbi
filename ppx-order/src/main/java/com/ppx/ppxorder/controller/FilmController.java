package com.ppx.ppxorder.controller;

import com.ppx.ppxorder.entity.FilmInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
@RestController
@RequestMapping(value = "/film")
@Slf4j
public class FilmController {
    @GetMapping("/films")
    public List<FilmInfo> getFilms(@RequestParam Integer pageIndex,@RequestParam Integer pageSize){
        List<FilmInfo> list=new ArrayList<>();
        return list;
    }

    @GetMapping("/test")
    public String getUser(){
        return "";
    }

}
