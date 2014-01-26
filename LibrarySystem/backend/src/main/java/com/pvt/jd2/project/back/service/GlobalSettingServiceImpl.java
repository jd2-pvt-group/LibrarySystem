package com.pvt.jd2.project.back.service;

import com.pvt.jd2.project.common.dao.GlobalSettingDao;
import com.pvt.jd2.project.common.domain.GlobalSetting;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import com.pvt.jd2.project.common.service.GlobalSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 26.01.14
 * Time: 4:11
 */
@Service
public class GlobalSettingServiceImpl implements GlobalSettingService{

    @Autowired
    private GlobalSettingDao globalSettingDao;

    @Override
    @Transactional
    public GlobalSetting findByName(String name) throws BusinessLogicException {
        try{
            return globalSettingDao.findByName(name);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public List<GlobalSetting> list() throws BusinessLogicException {
        try{
            return globalSettingDao.list();
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }
}
