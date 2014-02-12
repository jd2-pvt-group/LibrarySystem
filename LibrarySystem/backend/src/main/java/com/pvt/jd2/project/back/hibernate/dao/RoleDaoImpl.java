package com.pvt.jd2.project.back.hibernate.dao;

import com.pvt.jd2.project.common.dao.RoleDao;
import com.pvt.jd2.project.common.domain.Role;
import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.domain.metamodel.Role_;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import org.hibernate.*;
import org.hibernate.criterion.MatchMode;
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
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void delete(Role role) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.delete(role);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public boolean exists(Role role) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(Role_.NAME, role.getName()));
            return criteria.uniqueResult() == null ? false : true;
        }catch (HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void update(Role role) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.update(role);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public Role findById(Long id) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            return (Role)session.get(Role.class, id);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public Role findByIdFull(Long id) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.setFetchMode(Role_.PERMISSIONS, FetchMode.JOIN);
            criteria.add(Restrictions.eq(Role_.ID, id));
            return (Role)criteria.uniqueResult();
        }catch(HibernateException e){
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
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Role> list() throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            return (List<Role>)criteria.list();
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Role> listLike(Role role) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            if (!role.getName().isEmpty()){
                criteria.add(Restrictions.like(Role_.NAME, role.getName(), MatchMode.ANYWHERE));
            }
            if (!role.getDescription().isEmpty()){
                criteria.add(Restrictions.like(Role_.DESCRIPTION, role.getDescription(), MatchMode.ANYWHERE));
            }
            return (List<Role>)criteria.list();
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Role> listForUser(User user) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.createAlias(Role_.USERS, Role_.USER);
            criteria.add(Restrictions.eq(Role_.USER_ID, user.getId()));
            return (List<Role>)criteria.list();
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

}
