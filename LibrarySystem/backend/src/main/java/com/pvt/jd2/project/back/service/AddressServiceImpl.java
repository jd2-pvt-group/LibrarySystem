package com.pvt.jd2.project.back.service;

import com.pvt.jd2.project.common.dao.AddressDao;
import com.pvt.jd2.project.common.domain.Address;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import com.pvt.jd2.project.common.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 17:42
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;


    @Override
    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public AddressDao getAddressDao() {
        return addressDao;
    }

    @Override
    @Transactional
    public Address findById(Long id) throws BusinessLogicException {
        try{
            return addressDao.findById(id);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void create(Address address) throws BusinessLogicException {
        try{
            addressDao.create(address);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public void delete(Address address) throws BusinessLogicException {
        try{
            addressDao.delete(address);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<Address> list() throws BusinessLogicException {
        try{
            return addressDao.list();
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<Address> listByCountry(String countryName) throws BusinessLogicException {
        try{
            return addressDao.findByPartOfCountryName(countryName);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<Address> listByCity(String cityName) throws BusinessLogicException {
        try{
            return addressDao.findByPartOfCityName(cityName);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<Address> listByStreet(String streetName) throws BusinessLogicException {
        try{
            return addressDao.findByPartOfStreetName(streetName);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<Address> listByApartment(Integer apartmentNumber) throws BusinessLogicException {
        try{
            return addressDao.findByApartment(apartmentNumber);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }
}
