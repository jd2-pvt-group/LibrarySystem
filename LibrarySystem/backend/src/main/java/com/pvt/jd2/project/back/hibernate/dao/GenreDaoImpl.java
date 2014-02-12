package com.pvt.jd2.project.back.hibernate.dao;

import com.pvt.jd2.project.common.dao.GenreDao;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.Genre;
import com.pvt.jd2.project.common.domain.metamodel.Genre_;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 24.01.14
 * Time: 22:24
 */
@Repository
public class GenreDaoImpl implements GenreDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Genre genre) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.persist(genre);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void delete(Genre genre) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.delete(genre);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public void update(Genre genre) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            session.update(genre);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public boolean exists(Genre genre) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.add(Restrictions.eq(Genre_.NAME, genre.getName()));
            return criteria.uniqueResult() == null ? false : true;
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public Genre findById(Long id) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            return (Genre)session.get(Genre.class, id);
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Genre> findFor(Book book) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            criteria.createAlias(Genre_.BOOKS, Genre_.BOOK);
            criteria.add(Restrictions.eq(Genre_.BOOK_ID, book.getId()));
            return (List<Genre>)criteria.list();
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    private Criteria createCriteria(){
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Genre.class);
    }

    @Override
    public List<Genre> list() throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            return (List<Genre>)criteria.list();
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<Genre> listLike(Genre genre) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
            if (!genre.getName().isEmpty()){
                criteria.add(Restrictions.like(Genre_.NAME, genre.getName(), MatchMode.ANYWHERE));
            }
            if (!genre.getDescription().isEmpty()){
                criteria.add(Restrictions.like(Genre_.DESCRIPTION, genre.getDescription(), MatchMode.ANYWHERE));
            }
            return (List<Genre>)criteria.list();
        }catch(HibernateException e){
            throw new DatabaseException(e);
        }
    }

}
