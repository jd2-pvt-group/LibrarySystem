package com.pvt.jd2.project.back.hibernate.dao;

import com.pvt.jd2.project.common.dao.GlobalSettingDao;
import com.pvt.jd2.project.common.domain.GlobalSetting;
import com.pvt.jd2.project.common.domain.metamodel.GlobalSetting_;
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
 * Time: 22:39
 */
@Repository
public class GlobalSettingDaoImpl implements GlobalSettingDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Criteria createCriteria(){
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(GlobalSetting.class);
    }

    @Override
    public GlobalSetting findByName(String name) throws DatabaseException {
        try{
            Criteria criteria = createCriteria();
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
            Criteria criteria = createCriteria();
            return (List<GlobalSetting>)criteria.list();
        }catch(Exception e){
            throw new DatabaseException(e);
        }
    }
}
