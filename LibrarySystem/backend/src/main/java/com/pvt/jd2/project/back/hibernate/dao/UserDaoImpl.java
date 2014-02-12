package com.pvt.jd2.project.back.hibernate.dao;

import com.pvt.jd2.project.common.dao.UserDao;
import com.pvt.jd2.project.common.domain.ActivationStatus;
import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.domain.metamodel.User_;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import org.hibernate.*;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.SqlResultSetMapping;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 25.01.14
 * Time: 16:06
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(User user) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.persist(user);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void delete(User user) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.delete(user);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void update(User user) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(user);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public boolean isLoginExist(Long id, String login) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(User_.LOGIN, login));
            criteria.add(Restrictions.ne(User_.ID, id));
            return !criteria.list().isEmpty();
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public boolean isPassportNumberExist(Long id, String passportNumber) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(User_.PASS_NUMBER, passportNumber));
            criteria.add(Restrictions.ne(User_.ID, id));
            return !criteria.list().isEmpty();
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void activate(User user) throws DatabaseException {
        try{
            if (!user.isActive()){
                updateActiveStatus(user, true);
            }
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void deactivate(User user) throws DatabaseException {
        try{
            if (user.isActive()){
                updateActiveStatus(user, false);
            }
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    private void updateActiveStatus(User user, boolean isActive) {
        user.setActive(false);
        Session session = sessionFactory.getCurrentSession();
        session.merge(user);
    }

    private Criteria createCriteria(){
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(User.class);
    }

    @Override
    public User findById(Long id) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            return (User)session.get(User.class, id);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public User findByLoginPassword(String login, String password) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(User_.LOGIN, login));
            criteria.add(Restrictions.eq(User_.PASSWORD, password));
            criteria.setFetchMode(User_.ROLES, FetchMode.JOIN);
            return (User)criteria.uniqueResult();
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    public List<User> listLike(User user)throws DatabaseException {

        try{
            Criteria criteria = createCriteria();
            updateCriteriaLike(criteria, user);
            return (List<User>)criteria.list();
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }

    }

    @Override
    public User findByPassportNumber(String passportNumber) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(User_.PASS_NUMBER, passportNumber));
            List<User> users = (List<User>)criteria.list();
            return users.isEmpty() ? null : users.get(0);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<User> list(ActivationStatus status) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            updateCriteriaForStatus(criteria, status);
            return (List<User>)criteria.list();
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<User> listLike(User user, ActivationStatus status) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            updateCriteriaLike(criteria, user);
            updateCriteriaForStatus(criteria, status);
            return (List<User>)criteria.list();
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    private void updateCriteriaLike(Criteria criteria, User user){
        if(!user.getFirstName().isEmpty()){
            criteria.add(Restrictions.like(User_.FIRST_NAME, user.getFirstName(), MatchMode.ANYWHERE));
        }
        if(!user.getLastName().isEmpty()){
            criteria.add(Restrictions.like(User_.LAST_NAME, user.getLastName(), MatchMode.ANYWHERE));
        }
        if(!user.getAddress().isEmpty()){
            criteria.add(Restrictions.like(User_.ADDRESS, user.getAddress(), MatchMode.ANYWHERE));
        }
        if(!user.getPassportNumber().isEmpty()){
            criteria.add(Restrictions.like(User_.PASS_NUMBER, user.getPassportNumber(), MatchMode.ANYWHERE));
        }
    }

    private void updateCriteriaForStatus(Criteria criteria, ActivationStatus status) {
        switch (status){
            case ACTIVE:
                criteria.add(Restrictions.eq(User_.IS_ACTIVE, true));
                break;
            case INACTIVE:
                criteria.add(Restrictions.eq(User_.IS_ACTIVE, false));
                break;
        }
    }

}
