package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.Role;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 15:36
 */
public interface RoleDao {

    boolean create(Role address) throws DatabaseException;

    boolean delete(Role address) throws DatabaseException;

    List<Role> list() throws DatabaseException;

}
