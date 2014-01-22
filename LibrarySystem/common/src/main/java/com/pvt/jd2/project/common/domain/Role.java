package com.pvt.jd2.project.common.domain;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 12:28
 */
public interface Role {

    void setId(Long id);

    Long getId();

    void setName(String name);

    String getName();

    void setAttributes(List<Attribute> attributes);

    List<Attribute> getAttributes();

    void setUsers(List<User> users);

    List<User> getUsers();

}
