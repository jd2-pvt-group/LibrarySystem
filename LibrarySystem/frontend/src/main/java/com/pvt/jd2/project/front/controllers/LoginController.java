package com.pvt.jd2.project.front.controllers;

import com.pvt.jd2.project.common.domain.Permission;
import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.domain.metamodel.User_;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.service.PermissionService;
import com.pvt.jd2.project.common.service.UserService;
import com.pvt.jd2.project.front.util.Attributes;
import com.pvt.jd2.project.front.util.Messages;
import com.pvt.jd2.project.front.util.TilesDefinitions;
import com.pvt.jd2.project.front.validators.LoginFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
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
    private LoginFormValidator loginFormValidator;

    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
    public String login(@ModelAttribute User user, BindingResult result, Model model) {
        ValidationUtils.invokeValidator(loginFormValidator, user, result);
        if (result.hasErrors()){
            return TilesDefinitions.LOGIN_DEFINITION;
        }
        try{
            User loggedUser = userService.findByLoginPassword(user.getLogin(), user.getPassword());
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
    public String goToLoginPage(@ModelAttribute User user, BindingResult result) {
        return TilesDefinitions.LOGIN_DEFINITION;
    }

    @RequestMapping(value = "/logout", method = {RequestMethod.POST, RequestMethod.GET})
    public String logout(HttpSession session, SessionStatus status, @ModelAttribute User user){
        removeSessionAttributes(session);
        status.setComplete();
        return TilesDefinitions.LOGIN_DEFINITION;
    }

    private void removeSessionAttributes(HttpSession session) {
        session.removeAttribute(Attributes.SECTION);
        session.removeAttribute(Attributes.LOGGED_USER);
        session.removeAttribute(Attributes.LOGGED_PERMISSIONS);

        session.removeAttribute(Attributes.VIEWED_BOOK_EXEMPLAR_FORM_BEAN_FLOW);
        session.removeAttribute(Attributes.VIEWED_BOOK_TYPE_FLOW);
    }

}
