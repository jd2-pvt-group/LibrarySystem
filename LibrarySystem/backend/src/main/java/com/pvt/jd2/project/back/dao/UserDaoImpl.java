package com.pvt.jd2.project.back.dao;

import com.pvt.jd2.project.common.dao.UserDao;
import com.pvt.jd2.project.common.domain.ActivationStatus;
import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.domain.metamodel.User_;
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
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void delete(User user) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.delete(user);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void activate(User user) throws DatabaseException {
        try{
            if (!user.isActive()){
                updateActiveStatus(user, true);
            }
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void deactivate(User user) throws DatabaseException {
        try{
            if (user.isActive()){
                updateActiveStatus(user, false);
            }
        }catch(Exception e){
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
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(User_.ID, id));
            List<User> users = (List<User>)criteria.list();
            return users.isEmpty() ? null : users.get(0);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public User findByLoginPassword(String login, String password) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(User_.LOGIN, login));
            criteria.add(Restrictions.eq(User_.PASSWORD, password));
            List<User> users = (List<User>)criteria.list();
            return users.isEmpty() ? null : users.get(0);
        }catch(Exception e){
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
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<User> list(ActivationStatus status) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            updateCriteriaForStatus(criteria, status);
            return (List<User>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<User> listByPartOfFirstName(String partOfFirstName, ActivationStatus status) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            updateCriteriaForStatus(criteria, status);
            criteria.add(Restrictions.eq(User_.FIRST_NAME, partOfFirstName));
            return (List<User>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<User> listByPartOfLastName(String partOfLastName, ActivationStatus status) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            updateCriteriaForStatus(criteria, status);
            criteria.add(Restrictions.eq(User_.LAST_NAME, partOfLastName));
            return (List<User>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<User> listByPartOfAddress(String partOfAddress, ActivationStatus status) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            updateCriteriaForStatus(criteria, status);
            criteria.add(Restrictions.eq(User_.ADDRESS, partOfAddress));
            return (List<User>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<User> listByPartOfPassportNumber(String partOfPassportNumber, ActivationStatus status) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            updateCriteriaForStatus(criteria, status);
            criteria.add(Restrictions.eq(User_.PASS_NUMBER, partOfPassportNumber));
            return (List<User>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
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
