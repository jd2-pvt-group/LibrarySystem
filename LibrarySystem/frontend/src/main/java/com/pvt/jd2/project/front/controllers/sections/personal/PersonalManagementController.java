package com.pvt.jd2.project.front.controllers.sections.personal;

import com.pvt.jd2.project.common.domain.Language;
import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.service.LanguageService;
import com.pvt.jd2.project.common.service.UserService;
import com.pvt.jd2.project.front.util.Attributes;
import com.pvt.jd2.project.front.util.Parameters;
import com.pvt.jd2.project.front.util.TilesDefinitions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 31.01.14
 * Time: 4:34
 */
@Controller
@RequestMapping(value = "/management")
public class PersonalManagementController {

    @Autowired
    private UserService userService;

    @Autowired
    private LanguageService languageService;

    @ModelAttribute(value = Attributes.LANGUAGES)
    public List<Language> getLanguages(){
        return languageService.getLanguages();
    }

    @RequestMapping(value = "/personalSettings")
    public String viewPersonalSettings(){
        return TilesDefinitions.PERSONAL_MANAGEMENT_SETTINGS;
    }


    @RequestMapping(value = "/updatePersonalSettings")
    public String updateSettings(@ModelAttribute(value = Attributes.LANGUAGES) List<Language> languages){
        return TilesDefinitions.PERSONAL_MANAGEMENT_SETTINGS_UPDATE;
    }

    @RequestMapping(value = "/changePersonalSettings")
    public String changeSettings(){
        return TilesDefinitions.PERSONAL_MANAGEMENT_SETTINGS;
    }


}
