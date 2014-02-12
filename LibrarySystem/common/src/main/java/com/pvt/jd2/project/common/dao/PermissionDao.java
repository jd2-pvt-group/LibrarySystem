package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.Permission;
import com.pvt.jd2.project.common.domain.Role;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 24.01.14
 * Time: 22:00
 */
public interface PermissionDao {

    void create(Permission permission) throws DatabaseException;

    void delete(Permission permission) throws DatabaseException;

    Permission findById(Long id) throws DatabaseException;

    Permission findByCode(String code) throws DatabaseException;

    List<Permission> list() throws DatabaseException;

    List<Permission> listLike(Permission permission) throws DatabaseException;

    List<Permission> listForRole(Role role) throws DatabaseException;

}
