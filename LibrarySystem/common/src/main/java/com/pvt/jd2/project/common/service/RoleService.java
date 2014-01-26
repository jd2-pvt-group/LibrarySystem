package com.pvt.jd2.project.common.service;

import com.pvt.jd2.project.common.domain.Role;
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

    Role findById(Long id) throws BusinessLogicException;

    Role findByName(String name) throws BusinessLogicException;

    List<Role> list() throws BusinessLogicException;

    List<Role> listByPartOfName(String partOfName) throws BusinessLogicException;

    List<Role> listByPartOfDescription(String partOfDescription) throws BusinessLogicException;


}
