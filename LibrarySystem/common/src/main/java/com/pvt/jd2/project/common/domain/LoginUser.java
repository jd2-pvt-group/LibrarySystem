package com.pvt.jd2.project.common.domain;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 16:41
 */
public interface LoginUser extends User {

    void setLogin(String login);

    String getLogin();

    void setPassword(String password);

    String getPassword();

    void setRoles(List<Role> roles);

    List<Role> getRoles();

}
