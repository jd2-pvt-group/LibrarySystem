package com.pvt.jd2.project.back.hibernate.dao;

import com.pvt.jd2.project.common.dao.PermissionDao;
import com.pvt.jd2.project.common.domain.Permission;
import com.pvt.jd2.project.common.domain.Role;
import com.pvt.jd2.project.common.domain.metamodel.Permission_;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
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
    public void create(Permission permission) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.persist(permission);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void delete(Permission permission) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.delete(permission);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public Permission findById(Long id) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            return (Permission)session.get(Permission.class, id);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    private Criteria createCriteria(){
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Permission.class);
    }

    @Override
    public Permission findByCode(String code) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(Permission_.CODE, code));
            List<Permission> permissions = (List<Permission>)criteria.list();
            return permissions.isEmpty() ? null : permissions.get(0);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Permission> list() throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            return (List<Permission>)criteria.list();
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Permission> listLike(Permission permission) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            if (!permission.getCode().isEmpty()){
                criteria.add(Restrictions.like(Permission_.CODE, permission.getCode(), MatchMode.ANYWHERE));
            }
            if (!permission.getDescription().isEmpty()){
                criteria.add(Restrictions.like(Permission_.DESCRIPTION, permission.getDescription(), MatchMode.ANYWHERE));
            }
            return (List<Permission>)criteria.list();
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Permission> listForRole(Role role) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.createAlias(Permission_.ROLES, Permission_.ROLE);
            criteria.add(Restrictions.eq(Permission_.ROLE_ID, role.getId()));
            return (List<Permission>)criteria.list();
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

}
