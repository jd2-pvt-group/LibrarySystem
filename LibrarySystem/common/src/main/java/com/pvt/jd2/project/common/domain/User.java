package com.pvt.jd2.project.common.domain;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 12:28
 */
public interface User {

    void setId(Integer id);

    Integer getId();

    void setFirstName(String firstName);

    String getFirstName();

    void setLastName(String lastName);

    String getLastName();

    void setMiddleName(String middleName);

    String getMiddleName();

}
