package com.pvt.jd2.project.back.dao;

import com.pvt.jd2.project.common.dao.PermissionDao;
import com.pvt.jd2.project.common.domain.Permission;
import com.pvt.jd2.project.common.domain.metamodel.Permission_;
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
 * Date: 24.01.14
 * Time: 22:06
 */
@Repository
public class PermissionDaoImpl implements PermissionDao {

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
    public void create(Permission permission) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.persist(permission);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void delete(Permission permission) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.delete(permission);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public Permission findById(Long id) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            return (Permission)session.get(Permission.class, id);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public Permission findByCode(String code) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Permission.class);
            criteria.add(Restrictions.eq(Permission_.CODE, code));
            List<Permission> permissions = (List<Permission>)criteria.list();
            return permissions.isEmpty() ? null : permissions.get(0);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Permission> list() throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Permission.class);
            return (List<Permission>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Permission> findByPartOfCode(String partOfCode) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Permission.class);
            criteria.add(Restrictions.like(Permission_.CODE, partOfCode));
            return (List<Permission>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Permission> findByPartOfDescription(String partOfDescription) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Permission.class);
            criteria.add(Restrictions.like(Permission_.DESCRIPTION, partOfDescription));
            return (List<Permission>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }
}
