package com.pvt.jd2.project.front.controllers.sections;

import com.pvt.jd2.project.common.domain.Role;
import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.service.UserService;
import com.pvt.jd2.project.front.controllers.sections.library.CommonLogic;
import com.pvt.jd2.project.front.util.Attributes;
import com.pvt.jd2.project.front.util.Sections;
import com.pvt.jd2.project.front.util.TilesDefinitions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 29.01.14
 * Time: 15:59
 */
@Controller
@RequestMapping(value = "/management")
@SessionAttributes(value = Attributes.SECTION)
public class ManagementController extends CommonLogic {

    @RequestMapping(value = "/userManagement", method = RequestMethod.GET)
    public String userManagement(@ModelAttribute(value = Attributes.VIEWED_USER) User viewedUser,
                                 Model model, HttpSession session){
        model.addAttribute(Attributes.SECTION, Sections.USER_MANAGEMENT);
        removeSessionAttributes(session);
        return TilesDefinitions.USER_MANAGEMENT_FIND;
    }

    @RequestMapping(value = "/roleManagement", method = RequestMethod.GET)
    public String roleManagement(@ModelAttribute(value = Attributes.VIEWED_ROLE) Role findRole,
                                 Model model, HttpSession session){
        model.addAttribute(Attributes.SECTION, Sections.ROLE_MANAGEMENT);
        removeSessionAttributes(session);
        return TilesDefinitions.ROLE_MANAGEMENT_FIND;
    }

    @RequestMapping(value = "/libraryManagement", method = RequestMethod.GET)
    public String libraryManagement(Model model, HttpSession session){
        model.addAttribute(Attributes.SECTION, Sections.LIBRARY_MANAGEMENT);
        removeSessionAttributes(session);
        return TilesDefinitions.LIBRARY_MANAGEMENT_WELCOME;
    }

    @RequestMapping(value = "/personalManagement", method = RequestMethod.GET)
    public String personalManagement(Model model, HttpSession session){
        model.addAttribute(Attributes.SECTION, Sections.PERSONAL_MANAGEMENT);
        removeSessionAttributes(session);
        return TilesDefinitions.PERSONAL_MANAGEMENT_WELCOME;
    }

    @RequestMapping(value = "/*", method = RequestMethod.GET)
    public String redirectGet(){
        return TilesDefinitions.MANAGEMENT_WELCOME;
    }

}
