package com.pvt.jd2.project.common.service;

import com.pvt.jd2.project.common.domain.GlobalSetting;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 26.01.14
 * Time: 3:46
 */
public interface GlobalSettingService {

    GlobalSetting findByName(String name) throws BusinessLogicException;

    List<GlobalSetting> list() throws BusinessLogicException;

}
