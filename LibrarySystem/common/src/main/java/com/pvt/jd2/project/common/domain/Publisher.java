package com.pvt.jd2.project.common.domain;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 16:08
 */
public interface Publisher {

    void setId(Integer id);

    Integer getId();

    void setName(String name);

    String getName();

    void setAddress(Address address);

    Address getAddress();

}
