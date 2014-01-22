package com.pvt.jd2.project.back.domain;

import com.pvt.jd2.project.common.domain.LoginUser;
import com.pvt.jd2.project.common.domain.Role;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 17:24
 */
public class LoginUserImpl extends UserImpl implements Serializable, LoginUser {

    private String login;
    private String password;
    private List<Role> roles;

    public LoginUserImpl(){
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public void setPassword(String s) {
        this.password = password;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public List<Role> getRoles() {
        return roles;
    }
}
