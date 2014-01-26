package com.pvt.jd2.project.common.service;

import com.pvt.jd2.project.common.domain.Permission;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;

import java.util.List;

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

    List<Permission> listByPartOfCode(String partOfCode) throws BusinessLogicException;

    List<Permission> listByPartOfDescription(String partOfDescription) throws BusinessLogicException;


}
