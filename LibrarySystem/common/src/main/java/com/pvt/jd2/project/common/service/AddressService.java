package com.pvt.jd2.project.common.service;

import com.pvt.jd2.project.common.domain.Address;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 17:34
 */
public interface AddressService {

    Address create(Address address) throws BusinessLogicException;

    Address delete(Address address) throws BusinessLogicException;

    List<Address> list() throws BusinessLogicException;

    List<Address> listByCountry(String countryName) throws BusinessLogicException;

    List<Address> listByCity(String cityName) throws BusinessLogicException;

    List<Address> listByStreet(String streetName) throws BusinessLogicException;

    List<Address> listByApartment(Integer apartmentNumber) throws BusinessLogicException;

}
