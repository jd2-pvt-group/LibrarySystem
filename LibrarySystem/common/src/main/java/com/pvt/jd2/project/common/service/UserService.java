package com.pvt.jd2.project.common.service;

import com.pvt.jd2.project.common.domain.ActivationStatus;
import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 26.01.14
 * Time: 3:49
 */
public interface UserService {

    void create(User user) throws BusinessLogicException;

    void delete(User user) throws BusinessLogicException;

    void activate(User user) throws BusinessLogicException;

    void deactivate(User user) throws BusinessLogicException;

    User findById(Long id) throws BusinessLogicException;

    User findByLoginPassword(String login, String password) throws BusinessLogicException;

    User findByPassportNumber(String passportNumber) throws BusinessLogicException;

    List<User> list(ActivationStatus status) throws BusinessLogicException;

    List<User> listByPartOfFirstName(String partOfFirstName, ActivationStatus status) throws BusinessLogicException;

    List<User> listByPartOfLastName(String partOfLastName, ActivationStatus status) throws BusinessLogicException;

    List<User> listByPartOfAddress(String partOfAddress, ActivationStatus status) throws BusinessLogicException;

    List<User> listByPartOfPassportNumber(String partOfPassportNumber, ActivationStatus status) throws BusinessLogicException;


}
