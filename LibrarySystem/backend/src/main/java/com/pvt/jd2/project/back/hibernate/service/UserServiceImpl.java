package com.pvt.jd2.project.back.hibernate.service;

import com.pvt.jd2.project.common.dao.UserDao;
import com.pvt.jd2.project.common.domain.ActivationStatus;
import com.pvt.jd2.project.common.domain.Role;
import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import com.pvt.jd2.project.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 26.01.14
 * Time: 4:25
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public User create(User user) throws BusinessLogicException {
        try{
          return  userDao.create(user);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void update(User user) throws BusinessLogicException {
        try{
            userDao.update(user);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public boolean isLoginExist(Long id, String login) throws BusinessLogicException {
        try{
            return userDao.isLoginExist(id, login);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }



    @Override
    @Transactional
    public boolean isPassportNumberExist(Long id, String passportNumber) throws BusinessLogicException {
        try{
            return userDao.isPassportNumberExist(id, passportNumber);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void delete(User user) throws BusinessLogicException {
        try{
            userDao.delete(user);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void activate(User user) throws BusinessLogicException {
        try{
            userDao.activate(user);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void deactivate(User user) throws BusinessLogicException {
        try{
            userDao.deactivate(user);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public User findById(Long id) throws BusinessLogicException {
        try{
            return userDao.findById(id);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public User findByLoginPassword(String login, String password) throws BusinessLogicException {
        try{
            return userDao.findByLoginPassword(login, password);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public User findByPassportNumber(String passportNumber) throws BusinessLogicException {
        try{
            return userDao.findByPassportNumber(passportNumber);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<User> list(ActivationStatus status) throws BusinessLogicException {
        try{
            return userDao.list(status);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<User> listLike(User user) throws BusinessLogicException {
        try{
            return userDao.listLike(user);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<User> listLike(User user, ActivationStatus status) throws BusinessLogicException {
        try{
            return userDao.listLike(user, status);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<Role> addRoles(Long id, List<Role> roles)throws BusinessLogicException {
        List<Role> roleList=userDao.findById(id).getRoles();
        for(Role role:roles){
            if(!roleList.contains(role))
            {
                roleList.add(role);
            }


        }
        return roleList;
    }

    @Override
    @Transactional
    public List<Role> removeRole(Long id, Role role) throws BusinessLogicException {
        User user =userDao.findById(id);
        List<Role> roleList=user.getRoles();
        roleList.remove(role);
        return roleList;
    }


}
