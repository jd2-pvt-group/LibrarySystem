package com.pvt.jd2.project.back.service;

import com.pvt.jd2.project.common.dao.PermissionDao;
import com.pvt.jd2.project.common.domain.Permission;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import com.pvt.jd2.project.common.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void create(Permission permission) throws BusinessLogicException {
        try{
            permissionDao.create(permission);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public void delete(Permission permission) throws BusinessLogicException {
        try{
            permissionDao.delete(permission);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public Permission findById(Long id) throws BusinessLogicException {
        try{
            return permissionDao.findById(id);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public Permission findByCode(String code) throws BusinessLogicException {
        try{
            return permissionDao.findByCode(code);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<Permission> list() throws BusinessLogicException {
        try{
            return permissionDao.list();
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<Permission> listByPartOfCode(String partOfCode) throws BusinessLogicException {
        try{
            return permissionDao.listByPartOfCode(partOfCode);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<Permission> listByPartOfDescription(String partOfDescription) throws BusinessLogicException {
        try{
            return permissionDao.listByPartOfDescription(partOfDescription);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }
}
