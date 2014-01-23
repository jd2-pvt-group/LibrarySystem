package com.pvt.jd2.project.common.domain;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 17:22
 */
public class Genre implements Serializable {

    private Long id;
    private String name;

    public Genre(){
    }

    public void setId(Long integer) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
