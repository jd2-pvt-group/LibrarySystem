package com.pvt.jd2.project.back.service;

import com.pvt.jd2.project.common.dao.RoleDao;
import com.pvt.jd2.project.common.domain.Role;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import com.pvt.jd2.project.common.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 26.01.14
 * Time: 4:22
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public void create(Role role) throws BusinessLogicException {
        try{
            roleDao.create(role);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public void delete(Role role) throws BusinessLogicException {
        try{
            roleDao.delete(role);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public Role findById(Long id) throws BusinessLogicException {
        try{
            return roleDao.findById(id);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public Role findByName(String name) throws BusinessLogicException {
        try{
            return roleDao.findByName(name);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<Role> list() throws BusinessLogicException {
        try{
            return roleDao.list();
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<Role> listByPartOfName(String partOfName) throws BusinessLogicException {
        try{
            return roleDao.listByPartOfName(partOfName);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<Role> listByPartOfDescription(String partOfDescription) throws BusinessLogicException {
        try{
            return roleDao.listByPartOfDescription(partOfDescription);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }
}
