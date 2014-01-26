package com.pvt.jd2.project.back.service;

import com.pvt.jd2.project.common.dao.UserDao;
import com.pvt.jd2.project.common.domain.ActivationStatus;
import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import com.pvt.jd2.project.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void create(User user) throws BusinessLogicException {
        try{
            userDao.create(user);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public void delete(User user) throws BusinessLogicException {
        try{
            userDao.delete(user);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public void activate(User user) throws BusinessLogicException {
        try{
            userDao.activate(user);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public void deactivate(User user) throws BusinessLogicException {
        try{
            userDao.deactivate(user);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public User findById(Long id) throws BusinessLogicException {
        try{
            return userDao.findById(id);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public User findByLoginPassword(String login, String password) throws BusinessLogicException {
        try{
            return userDao.findByLoginPassword(login, password);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public User findByPassportNumber(String passportNumber) throws BusinessLogicException {
        try{
            return userDao.findByPassportNumber(passportNumber);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<User> list(ActivationStatus status) throws BusinessLogicException {
        try{
            return userDao.list(status);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<User> listByPartOfFirstName(String partOfFirstName, ActivationStatus status) throws BusinessLogicException {
        try{
            return userDao.listByPartOfFirstName(partOfFirstName, status);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<User> listByPartOfLastName(String partOfLastName, ActivationStatus status) throws BusinessLogicException {
        try{
            return userDao.listByPartOfLastName(partOfLastName, status);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<User> listByPartOfAddress(String partOfAddress, ActivationStatus status) throws BusinessLogicException {
        try{
            return userDao.listByPartOfAddress(partOfAddress, status);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public List<User> listByPartOfPassportNumber(String partOfPassportNumber, ActivationStatus status) throws BusinessLogicException {
        try{
            return userDao.listByPartOfPassportNumber(partOfPassportNumber, status);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }
}
