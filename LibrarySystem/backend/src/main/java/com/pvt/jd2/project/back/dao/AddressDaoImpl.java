package com.pvt.jd2.project.back.dao;

import com.pvt.jd2.project.back.domain.metamodel.Address_;
import com.pvt.jd2.project.common.dao.AddressDao;
import com.pvt.jd2.project.common.domain.Address;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
    private EntityManager entityManager;

    @Override
    public void create(Address address) throws DatabaseException {
        try{
            entityManager.persist(address);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void delete(Address address) throws DatabaseException {
        try{
            entityManager.remove(address);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Address> list() throws DatabaseException {
        try{
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Address> query = criteriaBuilder.createQuery(Address.class);
            Root<Address> root = query.from(Address.class);
            query.select(root);
            return entityManager.createQuery(query).getResultList();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public Address findById(Long id) throws DatabaseException {
        try{
            return entityManager.find(Address.class, id);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Address> findByPartOfCountryName(String partOfCountryName) throws DatabaseException {
        try{
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Address> query = criteriaBuilder.createQuery(Address.class);
            Root<Address> root = query.from(Address.class);
            query.select(root);
            query.where(criteriaBuilder.like(root.get(Address_.country), partOfCountryName));
            return entityManager.createQuery(query).getResultList();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Address> findByPartOfCityName(String partOfCityName) throws DatabaseException {
        try{
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Address> query = criteriaBuilder.createQuery(Address.class);
            Root<Address> root = query.from(Address.class);
            query.select(root);
            query.where(criteriaBuilder.like(root.get(Address_.city), partOfCityName));
            return entityManager.createQuery(query).getResultList();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Address> findByPartOfStreetName(String partOfStreetName) throws DatabaseException {
        try{
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Address> query = criteriaBuilder.createQuery(Address.class);
            Root<Address> root = query.from(Address.class);
            query.select(root);
            query.where(criteriaBuilder.like(root.get(Address_.street), partOfStreetName));
            return entityManager.createQuery(query).getResultList();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Address> findByApartment(Integer apartmentNumber) throws DatabaseException {
        try{
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Address> query = criteriaBuilder.createQuery(Address.class);
            Root<Address> root = query.from(Address.class);
            query.select(root);
            query.where(criteriaBuilder.equal(root.get(Address_.apartment), apartmentNumber));
            return entityManager.createQuery(query).getResultList();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }
}
