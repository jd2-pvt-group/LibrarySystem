package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.Role;
import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 24.01.14
 * Time: 23:00
 */
public interface RoleDao {

    void create(Role role) throws DatabaseException;

    void delete(Role role) throws DatabaseException;

    boolean exists(Role role) throws DatabaseException;

    void update(Role role) throws DatabaseException;

    Role findById(Long id) throws DatabaseException;

    Role findByIdFull(Long id) throws DatabaseException;

    Role findByName(String name) throws DatabaseException;

    List<Role> list() throws DatabaseException;

    List<Role> listLike(Role role) throws DatabaseException;

    List<Role> listForUser(User user) throws DatabaseException;
}
