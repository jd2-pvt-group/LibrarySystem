package com.pvt.jd2.project.back.service;

import com.pvt.jd2.project.common.dao.AddressDao;
import com.pvt.jd2.project.common.domain.Address;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import com.pvt.jd2.project.common.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Address create(Address address) throws BusinessLogicException {
        try{
            addressDao.create(address);
            return address;
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    public Address delete(Address address) throws BusinessLogicException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Address> list() throws BusinessLogicException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Address> listByCountry(String countryName) throws BusinessLogicException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Address> listByCity(String cityName) throws BusinessLogicException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Address> listByStreet(String streetName) throws BusinessLogicException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Address> listByApartment(Integer apartmentNumber) throws BusinessLogicException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
