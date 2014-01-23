package com.pvt.jd2.project.common.domain;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 20.01.14
 * Time: 20:03
 */
public class Attribute implements Serializable {

    private Long id;

    private String code;

    private String description;

    public Attribute(){
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCode(String s) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
