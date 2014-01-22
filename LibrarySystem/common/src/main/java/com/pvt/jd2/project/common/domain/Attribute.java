package com.pvt.jd2.project.common.domain;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 12:29
 */
public interface Attribute {

    void setId(Long id);

    Long getId();

    void setCode(String code);

    String getCode();

    void setDescription(String description);

    String getDescription();

}
