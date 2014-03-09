package com.pvt.jd2.project.front.controllers;

import com.pvt.jd2.project.common.domain.Language;
import com.pvt.jd2.project.common.domain.Permission;
import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.domain.metamodel.User_;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.service.LanguageService;
import com.pvt.jd2.project.common.service.PermissionService;
import com.pvt.jd2.project.common.service.UserService;
import com.pvt.jd2.project.front.formbeans.LoginForm;
import com.pvt.jd2.project.front.util.Attributes;
import com.pvt.jd2.project.front.util.Messages;
import com.pvt.jd2.project.front.util.TilesDefinitions;
import com.pvt.jd2.project.front.validators.LoginFormValidator;
import com.pvt.jd2.project.front.validators.generic.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 28.01.14
 * Time: 1:06
 */
@Controller
@SessionAttributes(value =
        {Attributes.LOGGED_USER,
        Attributes.LOGGED_PERMISSIONS})
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private LanguageService languageService;

    @Autowired
    private LoginFormValidator loginFormValidator;

    @ModelAttribute(value = Attributes.LANGUAGES)
    public List<Language> getLanguages(){
        return languageService.getLanguages();
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.POST})
    public String login(@ModelAttribute(value = Attributes.LOGIN_FORM) LoginForm loginForm,
                        BindingResult result, Model model,
                        @ModelAttribute(value = Attributes.LANGUAGES) List<Language> languages) {
        ValidationUtils.invokeValidator(loginFormValidator, loginForm, result);
        if (result.hasErrors()){
            return TilesDefinitions.LOGIN_DEFINITION;
        }
        try{
            User loggedUser = userService.findByLoginPassword(loginForm.getLogin(), loginForm.getPassword());
            if (loggedUser != null){
                if (!loggedUser.getRoles().isEmpty()){
                    Set<Permission> permissions = permissionService.listForRoles(loggedUser.getRoles());
                    model.addAttribute(Attributes.LOGGED_USER, loggedUser);
                    model.addAttribute(Attributes.LOGGED_PERMISSIONS, permissions);
                    return TilesDefinitions.MANAGEMENT_WELCOME;
                }
            }
            result.rejectValue(User_.LOGIN, Messages.LOGIN_PAGE_LOGIN_IS_WRONG);
            return TilesDefinitions.LOGIN_DEFINITION;
        }catch(BusinessLogicException e){
            e.printStackTrace();
            return TilesDefinitions.LOGIN_ERROR_DEFINITION;
        }
    }

    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
    public String goToLoginPage(@ModelAttribute(value = Attributes.LOGIN_FORM) LoginForm loginForm,
                                @ModelAttribute(value = Attributes.LANGUAGES) List<Language> languages) {
        return TilesDefinitions.LOGIN_DEFINITION;
    }

    @RequestMapping(value = "/logout", method = {RequestMethod.POST, RequestMethod.GET})
    public String logout(HttpSession session, SessionStatus status,
                         @ModelAttribute(value = Attributes.LOGIN_FORM) LoginForm loginForm,
                         @ModelAttribute(value = Attributes.LANGUAGES) List<Language> languages){
        removeSessionAttributes(session);
        status.setComplete();
        return TilesDefinitions.LOGIN_DEFINITION;
    }

    private void removeSessionAttributes(HttpSession session) {
        session.removeAttribute(Attributes.SECTION);
        session.removeAttribute(Attributes.LOGGED_USER);
        session.removeAttribute(Attributes.LOGGED_PERMISSIONS);

        session.removeAttribute(Attributes.VIEWED_BOOK_EXEMPLAR_FLOW);
        session.removeAttribute(Attributes.VIEWED_BOOK_TYPE_FLOW);
    }

}
