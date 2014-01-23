package com.pvt.jd2.project.back.dao;

import com.pvt.jd2.project.common.domain.metamodel.Address_;
import com.pvt.jd2.project.common.dao.AddressDao;
import com.pvt.jd2.project.common.domain.Address;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 17:38
 */
@Repository
public class AddressDaoImpl implements AddressDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void create(Address address) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.persist(address);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void delete(Address address) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.delete(address);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Address> list() throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Address.class);
            List<Address> list = (List<Address>)criteria.list();
            return list;
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public Address findById(Long id) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            return (Address)session.get(Address.class, id);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Address> findByPartOfCountryName(String partOfCountryName) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Address.class);
            criteria.add(Restrictions.like(Address_.ID, partOfCountryName));
            return (List<Address>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Address> findByPartOfCityName(String partOfCityName) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Address.class);
            criteria.add(Restrictions.like(Address_.CITY, partOfCityName));
            return (List<Address>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Address> findByPartOfStreetName(String partOfStreetName) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Address.class);
            criteria.add(Restrictions.like(Address_.STREET, partOfStreetName));
            return (List<Address>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Address> findByApartment(Integer apartmentNumber) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Address.class);
            criteria.add(Restrictions.like(Address_.APARTMENT, apartmentNumber));
            return (List<Address>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }
}
