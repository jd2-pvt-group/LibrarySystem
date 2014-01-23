package com.pvt.jd2.project.common.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 17:24
 */
public class LoginUser extends User implements Serializable {

    private String login;
    private String password;
    private List<Role> roles;

    public LoginUser(){
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setPassword(String s) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Role> getRoles() {
        return roles;
    }
}
