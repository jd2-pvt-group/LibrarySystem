package com.pvt.jd2.project.common.service;

import com.pvt.jd2.project.common.domain.Permission;
import com.pvt.jd2.project.common.domain.Role;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;

import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 26.01.14
 * Time: 3:47
 */
public interface PermissionService {

    void create(Permission permission) throws BusinessLogicException;

    void delete(Permission permission) throws BusinessLogicException;

    Permission findById(Long id) throws BusinessLogicException;

    Permission findByCode(String code) throws BusinessLogicException;

    List<Permission> list() throws BusinessLogicException;

    List<Permission> listLike(Permission permission) throws BusinessLogicException;

    List<Permission> listForRole(Role role) throws BusinessLogicException;

    Set<Permission> listForRoles(List<Role> roles) throws BusinessLogicException;

    List<Permission> listNotInRole(Role role) throws BusinessLogicException;
}
