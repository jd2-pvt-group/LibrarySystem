package com.pvt.jd2.project.common.dao;

import com.pvt.jd2.project.common.domain.Address;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 17:31
 */
public interface AddressDao {

    void setSessionFactory(SessionFactory sessionFactory);

    SessionFactory getSessionFactory();

    void create(Address address) throws DatabaseException;

    void delete(Address address) throws DatabaseException;

    List<Address> list() throws DatabaseException;

    Address findById(Long id) throws DatabaseException;

    List<Address> findByPartOfCountryName(String partOfCountryName) throws DatabaseException;

    List<Address> findByPartOfCityName(String partOfCityName) throws DatabaseException;

    List<Address> findByPartOfStreetName(String partOfStreetName) throws DatabaseException;

    List<Address> findByApartment(Integer apartmentNumber) throws DatabaseException;

}
