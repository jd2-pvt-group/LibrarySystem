package com.pvt.jd2.project.back.domain;

import com.pvt.jd2.project.common.domain.User;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * UserImpl: Oleg
 * Date: 20.01.14
 * Time: 16:45
*/
public class UserImpl implements Serializable, User {

    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;

    public UserImpl(){
    }

    @Override
    public void setId(Long integer) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public String getMiddleName() {
        return middleName;
    }
}
