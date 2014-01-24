package com.pvt.jd2.project.back.dao;

import com.pvt.jd2.project.common.dao.AuthorDao;
import com.pvt.jd2.project.common.domain.Author;
import com.pvt.jd2.project.common.domain.metamodel.Author_;
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
public class AuthorDaoImpl implements AuthorDao {

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
    public void create(Author author) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.persist(author);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void delete(Author author) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.delete(author);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Author> list() throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Author.class);
            List<Author> list = (List<Author>)criteria.list();
            return list;
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public Author findById(Long id) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            return (Author)session.get(Author.class, id);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Author> findByPartOfFirstName(String partOfFirstName) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Author.class);
            criteria.add(Restrictions.like(Author_.FIRST_NAME, partOfFirstName));
            return (List<Author>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Author> findByPartOfLastName(String partOfLastName) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Author.class);
            criteria.add(Restrictions.like(Author_.LAST_NAME, partOfLastName));
            return (List<Author>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

}
