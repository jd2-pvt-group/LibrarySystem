package com.pvt.jd2.project.back.hibernate.service;

import com.pvt.jd2.project.common.dao.PermissionDao;
import com.pvt.jd2.project.common.domain.Permission;
import com.pvt.jd2.project.common.domain.Role;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import com.pvt.jd2.project.common.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 26.01.14
 * Time: 4:14
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    @Transactional
    public void create(Permission permission) throws BusinessLogicException {
        try{
            permissionDao.create(permission);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void delete(Permission permission) throws BusinessLogicException {
        try{
            permissionDao.delete(permission);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public Permission findById(Long id) throws BusinessLogicException {
        try{
            return permissionDao.findById(id);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public Permission findByCode(String code) throws BusinessLogicException {
        try{
            return permissionDao.findByCode(code);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<Permission> list() throws BusinessLogicException {
        try{
            return permissionDao.list();
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<Permission> listLike(Permission permission) throws BusinessLogicException {
        try{
            return permissionDao.listLike(permission);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<Permission> listForRole(Role role) throws BusinessLogicException {
        try{
            return permissionDao.listForRole(role);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public Set<Permission> listForRoles(List<Role> roles) throws BusinessLogicException {
        try{
            Set<Permission> result = new HashSet<Permission>();
            for(Role role : roles){
                result.addAll(permissionDao.listForRole(role));
            }
            return result;
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<Permission> listNotInRole(Role role) throws BusinessLogicException {
        try{
            List<Permission> allPermissions = permissionDao.list();
            List<Permission> toRemove = permissionDao.listForRole(role);
            allPermissions.removeAll(toRemove);
            return allPermissions;
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }
}
