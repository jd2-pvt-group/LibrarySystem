package com.pvt.jd2.project.back.dao;

import com.pvt.jd2.project.common.dao.RoleDao;
import com.pvt.jd2.project.common.domain.Role;
import com.pvt.jd2.project.common.domain.metamodel.Role_;
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
 * Time: 23:05
 */
@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Role role) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.persist(role);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void delete(Role role) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.delete(role);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public Role findById(Long id) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            return (Role)session.get(Role.class, id);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    private Criteria createCriteria(){
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Role.class);
    }

    @Override
    public Role findByName(String name) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(Role_.NAME, name));
            List<Role> roles = (List<Role>)criteria.list();
            return roles.isEmpty() ? null : roles.get(0);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Role> list() throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            return (List<Role>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Role> listByPartOfName(String partOfName) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.like(Role_.NAME, partOfName));
            return (List<Role>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Role> listByPartOfDescription(String partOfDescription) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.like(Role_.DESCRIPTION, partOfDescription));
            return (List<Role>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

}
