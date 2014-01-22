package com.pvt.jd2.project.back.domain;

import com.pvt.jd2.project.common.domain.Genre;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 17:22
 */
public class GenreImpl implements Serializable, Genre {

    private Integer id;
    private String name;

    public GenreImpl(){
    }

    @Override
    public void setId(Integer integer) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
