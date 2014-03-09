package com.pvt.jd2.project.common.service;

import com.pvt.jd2.project.common.domain.ActivationStatus;
import com.pvt.jd2.project.common.domain.Role;
import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 26.01.14
 * Time: 3:49
 */
public interface UserService {

    User create(User user) throws BusinessLogicException;

    void update(User user) throws BusinessLogicException;

    boolean isLoginExist(Long id, String login) throws BusinessLogicException;

    boolean isPassportNumberExist(Long id, String passportNumber) throws BusinessLogicException;

    void delete(User user) throws BusinessLogicException;

    void activate(User user) throws BusinessLogicException;

    void deactivate(User user) throws BusinessLogicException;

    User findById(Long id) throws BusinessLogicException;

    User findByLoginPassword(String login, String password) throws BusinessLogicException;

    User findByPassportNumber(String passportNumber) throws BusinessLogicException;

    List<User> list(ActivationStatus status) throws BusinessLogicException;

    List<User> listLike(User user)throws BusinessLogicException;

    List<User> listLike(User user, ActivationStatus status)throws BusinessLogicException;
    List <Role>addRoles(Long idUser, List<Role>rolesList)throws BusinessLogicException;
    List <Role>removeRole(Long idUser, Role role)throws BusinessLogicException;

}
