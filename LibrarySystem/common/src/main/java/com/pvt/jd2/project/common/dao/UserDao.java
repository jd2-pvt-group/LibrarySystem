package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.ActivationStatus;
import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.exceptions.DatabaseException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 25.01.14
 * Time: 15:58
 */
public interface UserDao {

    void create(User user) throws DatabaseException;

    void delete(User user) throws DatabaseException;

    void activate(User user) throws DatabaseException;

    void deactivate(User user) throws DatabaseException;

    User findById(Long id) throws DatabaseException;

    User findByLoginPassword(String login, String password) throws DatabaseException;

    User findByPassportNumber(String passportNumber) throws DatabaseException;

    List<User> list(ActivationStatus status) throws DatabaseException;

    List<User> listByPartOfFirstName(String partOfFirstName, ActivationStatus status) throws DatabaseException;

    List<User> listByPartOfLastName(String partOfLastName, ActivationStatus status) throws DatabaseException;

    List<User> listByPartOfAddress(String partOfAddress, ActivationStatus status) throws DatabaseException;

    List<User> listByPartOfPassportNumber(String partOfPassportNumber, ActivationStatus status) throws DatabaseException;

}
