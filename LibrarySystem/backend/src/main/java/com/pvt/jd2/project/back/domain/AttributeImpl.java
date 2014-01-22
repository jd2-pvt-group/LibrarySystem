package com.pvt.jd2.project.back.domain;

import com.pvt.jd2.project.common.domain.Attribute;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * UserImpl: Oleg
 * Date: 20.01.14
 * Time: 20:03
 */
public class AttributeImpl implements Serializable, Attribute {

    private Integer id;

    private String code;

    private String description;

    public AttributeImpl(){
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setCode(String s) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
