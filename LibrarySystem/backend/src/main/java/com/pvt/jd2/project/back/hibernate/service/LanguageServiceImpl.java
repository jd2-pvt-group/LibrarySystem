package com.pvt.jd2.project.back.hibernate.service;

import com.pvt.jd2.project.common.dao.LanguageDao;
import com.pvt.jd2.project.common.domain.Language;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.exceptions.DatabaseException;
import com.pvt.jd2.project.common.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 01.03.14
 * Time: 0:19
 */
@Service
public class LanguageServiceImpl implements LanguageService{

    @Autowired
    private LanguageDao languageDao;

    @Override
    @Transactional
    public List<Language> getLanguages() throws BusinessLogicException {
        try{
            return languageDao.getLanguages();
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

    @Override
    @Transactional
    public Language findByShortName(String shortName) throws BusinessLogicException {
        try{
            return languageDao.findByShortName(shortName);
        }catch(DatabaseException e){
            throw new BusinessLogicException(e);
        }
    }

}
