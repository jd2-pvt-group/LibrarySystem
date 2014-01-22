package com.pvt.jd2.project.back.domain;

import com.pvt.jd2.project.common.domain.Attribute;
import com.pvt.jd2.project.common.domain.Role;
import com.pvt.jd2.project.common.domain.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * UserImpl: Oleg
 * Date: 20.01.14
 * Time: 16:48
 */
public class RoleImpl implements Serializable, Role {

    private Long id;
    private String name;
    private List<Attribute> attributes;
    private List<User> users;

    public RoleImpl(){
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
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    @Override
    public List<Attribute> getAttributes() {
        return attributes;
    }

    @Override
    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public List<User> getUsers() {
        return users;
    }
}
