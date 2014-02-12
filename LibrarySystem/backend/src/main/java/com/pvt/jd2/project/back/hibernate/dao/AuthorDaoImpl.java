package com.pvt.jd2.project.back.hibernate.dao;

import com.pvt.jd2.project.common.dao.AuthorDao;
import com.pvt.jd2.project.common.domain.Author;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.metamodel.Author_;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
    public void create(Author author) throws DatabaseException {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.persist(author);
        } catch (HibernateException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public void delete(Author author) throws DatabaseException {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.delete(author);
        } catch (HibernateException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public void update(Author author) throws DatabaseException {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.update(author);
        } catch (HibernateException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public boolean exists(Author author) throws DatabaseException {
        try {
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(Author_.FIRST_NAME, author.getFirstName()));
            criteria.add(Restrictions.eq(Author_.LAST_NAME, author.getLastName()));
            return criteria.uniqueResult() == null ? false : true;
        } catch (HibernateException e) {
            throw new DatabaseException(e);
        }
    }

    private Criteria createCriteria() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Author.class);
    }

    @Override
    public List<Author> list() throws DatabaseException {
        try {
            Criteria criteria = createCriteria();
            List<Author> list = (List<Author>) criteria.list();
            return list;
        } catch (HibernateException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public Author findById(Long id) throws DatabaseException {
        try {
            Session session = sessionFactory.getCurrentSession();
            return (Author)session.get(Author.class, id);
        } catch (HibernateException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Author> listLike(Author author) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            if (!author.getLastName().isEmpty()){
                criteria.add(Restrictions.like(Author_.LAST_NAME, author.getLastName(), MatchMode.ANYWHERE));
            }
            if (!author.getFirstName().isEmpty()){
                criteria.add(Restrictions.like(Author_.FIRST_NAME, author.getFirstName(), MatchMode.ANYWHERE));
            }
            return (List<Author>)criteria.list();
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Author> findFor(Book book) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.createAlias(Author_.BOOKS, Author_.BOOK);
            criteria.add(Restrictions.eq(Author_.BOOK_ID, book.getId()));
            return (List<Author>)criteria.list();
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

}
