package com.pvt.jd2.project.back.hibernate.service;

import com.pvt.jd2.project.common.dao.RoleDao;
import com.pvt.jd2.project.common.domain.Role;
import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import com.pvt.jd2.project.common.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void create(Role role) throws BusinessLogicException {
        try{
            roleDao.create(role);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void delete(Role role) throws BusinessLogicException {
        try{
            roleDao.delete(role);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public boolean exists(Role role) throws BusinessLogicException {
        try{
            return roleDao.exists(role);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void update(Role role) throws BusinessLogicException {
        try{
            roleDao.update(role);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public Role findById(Long id) throws BusinessLogicException {
        try{
            return roleDao.findById(id);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public Role findByIdFull(Long id) throws BusinessLogicException {
        try{
            return roleDao.findByIdFull(id);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public Role findByName(String name) throws BusinessLogicException {
        try{
            return roleDao.findByName(name);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<Role> list() throws BusinessLogicException {
        try{
            return roleDao.list();
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<Role> listLike(Role role) throws BusinessLogicException {
        try{
            return roleDao.listLike(role);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<Role> listForUser(User user) throws BusinessLogicException {
        try{
            return roleDao.listForUser(user);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

}
