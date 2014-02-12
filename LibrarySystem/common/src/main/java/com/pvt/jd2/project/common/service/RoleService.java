package com.pvt.jd2.project.common.service;

import com.pvt.jd2.project.common.domain.Role;
import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 26.01.14
 * Time: 3:49
 */
public interface RoleService {

    void create(Role role) throws BusinessLogicException;

    void delete(Role role) throws BusinessLogicException;

    public boolean exists(Role role) throws BusinessLogicException;

    void update(Role role) throws BusinessLogicException;

    Role findById(Long id) throws BusinessLogicException;

    Role findByIdFull(Long id) throws BusinessLogicException;

    Role findByName(String name) throws BusinessLogicException;

    List<Role> list() throws BusinessLogicException;

    List<Role> listLike(Role role) throws BusinessLogicException;

    List<Role> listForUser(User user) throws BusinessLogicException;
}
