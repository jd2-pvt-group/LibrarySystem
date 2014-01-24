package com.pvt.jd2.project.back.dao;

import com.pvt.jd2.project.common.dao.GlobalSettingDao;
import com.pvt.jd2.project.common.domain.GlobalSetting;
import com.pvt.jd2.project.common.domain.metamodel.GlobalSetting_;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 24.01.14
 * Time: 22:39
 */
public class GlobalSettingDaoImpl implements GlobalSettingDao {

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
    public GlobalSetting findByName(String name) throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(GlobalSetting.class);
            criteria.add(Restrictions.eq(GlobalSetting_.NAME, name));
            List<GlobalSetting> settings = (List<GlobalSetting>)criteria.list();
            return settings.isEmpty() ? null : settings.get(0);
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }

    @Override
    public List<GlobalSetting> list() throws DatabaseException {
        try{
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(GlobalSetting.class);
            return (List<GlobalSetting>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }
}
