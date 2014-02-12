package com.pvt.jd2.project.front.controllers.sections.user;

import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.service.UserService;
import com.pvt.jd2.project.front.util.Attributes;
import com.pvt.jd2.project.front.util.Parameters;
import com.pvt.jd2.project.front.util.Sections;
import com.pvt.jd2.project.front.validators.UserValidator;
import com.pvt.jd2.project.front.validators.find.FindUserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.pvt.jd2.project.front.util.TilesDefinitions.*;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 29.01.14
 * Time: 19:44
 */
@Controller
@RequestMapping(value = "/management")
@SessionAttributes(value = Attributes.SECTION)
public class UserManagementController{

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;
    @Autowired
    private FindUserValidator findUserValidator;

    @RequestMapping(value = "/createUser")
    public String createUser(@ModelAttribute(value = Attributes.VIEWED_USER) User viewedUser,
                          BindingResult result,
                          @ModelAttribute(value = Attributes.SECTION) Sections section) {
      ValidationUtils.invokeValidator(userValidator, viewedUser, result);

        try{
            if (result.hasErrors()){
                return successUserAdd(section);
            }
            System.out.println(viewedUser);
          //  userService.update(viewedUser);
            successUserCreate(section,viewedUser);
            return successUserAdd(section);
        }catch(BusinessLogicException e){
            return error(section, e);
        }
    }


    @RequestMapping(value = "/addUser")
    public String addUser(@ModelAttribute(value = Attributes.VIEWED_USER) User viewedUser,
                          BindingResult result,
                          @ModelAttribute(value = Attributes.SECTION) Sections section) {

        return successUserAdd(section);
    }

    @RequestMapping(value = "/listUsers",method = RequestMethod.POST)
    public String listUsers(
            @ModelAttribute(value = Attributes.SECTION) Sections section, Model model){
        List<User> listViewedUser= null ;
        return successUsersList(section, listViewedUser,model );
    }

    @RequestMapping(value = "/findUser",method = RequestMethod.POST)
    public String findUser( @ModelAttribute(value = Attributes.VIEWED_USER) User viewedUser,
                           BindingResult result,
                           @ModelAttribute(value = Attributes.SECTION) Sections section) {

          //  updateModelWithUser(Long.valueOf(userId), model);
            return successUserFind(section);

    }

    @RequestMapping(value = "/foundUsers",method = RequestMethod.POST)
    public String foundUsers(
                          //   Model model,
                             @ModelAttribute(value = Attributes.VIEWED_USER) User viewedUser,
                             BindingResult result,
                           @ModelAttribute(value = Attributes.SECTION) Sections section,Model model) {
        ValidationUtils.invokeValidator(findUserValidator, viewedUser, result);
        if(result.hasErrors()){

        }
        try{
            List<User>foundList = userService.listLike(viewedUser);
            model.addAttribute(Attributes.VIEWED_USERS,foundList);
        } catch (BusinessLogicException e) {
            e.printStackTrace();
        }
        return USER_MANAGEMENT_LIST;
    }

    @RequestMapping(value = "/infoUser", method = RequestMethod.POST)
    public String infoUser(@RequestParam(value = Parameters.USER_ID) String userId,
                           Model model,
                           @ModelAttribute(value = Attributes.SECTION) Sections section) {
        try{
            updateModelWithUser(Long.valueOf(userId), model);
            return successInfoUser(section);
        }catch(BusinessLogicException e){
            return error(section, e);
        }
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public String updateUser(@RequestParam(value = Parameters.USER_ID) String userId,
                             Model model,
                             @ModelAttribute(value = Attributes.SECTION) Sections section) {
        try{
            updateModelWithUser(Long.valueOf(userId), model);
            return successUpdateUser(section);
        }catch(BusinessLogicException e){
            return error(section, e);
        }
    }

    @RequestMapping(value = "/changeUser", method = RequestMethod.POST)
    public String changeUser(@ModelAttribute(value = Attributes.VIEWED_USER) User viewedUser,
                             BindingResult result,
                             @ModelAttribute(value = Attributes.SECTION) Sections section) {
        ValidationUtils.invokeValidator(userValidator, viewedUser, result);
        try{
            if (result.hasErrors()){
                return successUpdateUser(section);
            }
            System.out.println(viewedUser);
            userService.update(viewedUser);
            return successInfoUser(section);
        }catch(BusinessLogicException e){
            return error(section, e);
        }
    }

    private void updateModelWithUser(Long userId, Model model) throws BusinessLogicException {
        User viewedUser = userService.findById(userId);
        model.addAttribute(Attributes.VIEWED_USER, viewedUser);
        System.out.println(viewedUser);
    }


    private String successUserAdd(Sections section){
        switch (section){
            case USER_MANAGEMENT:
                return USER_MANAGEMENT_ADD;
            default:
                return USER_MANAGEMENT_INFO;
        }
    }
    private String successUserCreate(Sections section,User user) throws BusinessLogicException {
        switch (section){
            case USER_MANAGEMENT:
                user.setActive(true);
                userService.create(user);
                return USER_MANAGEMENT_ADD;
            default:
                return USER_MANAGEMENT_INFO;
        }
    }

    private String successUserFind(Sections section){
        switch (section){
            case USER_MANAGEMENT:
                return USER_MANAGEMENT_FIND;
            default:
                return USER_MANAGEMENT_INFO;
        }
    }

    private String successUsersList(Sections section,List<User>userList,Model model){
        switch (section){
            case USER_MANAGEMENT:
                try {
                    userList=userService.listLike(new User());
                    model.addAttribute(Attributes.VIEWED_USERS,userList);
                } catch (BusinessLogicException e) {
                    e.printStackTrace();
                }
                return USER_MANAGEMENT_LIST;
            default:
                return USER_MANAGEMENT_INFO;
        }
    } 
      private String getFoundUsersList(User user){

          return null;
      }

    private String successInfoUser(Sections section){
        switch (section){
            case PERSONAL_MANAGEMENT:
                return PERSONAL_MANAGEMENT_USER_INFO;
            default:
                return USER_MANAGEMENT_INFO;
        }
    }

    private String successUpdateUser(Sections section) {
        switch(section){
            case PERSONAL_MANAGEMENT:
                return PERSONAL_MANAGEMENT_USER_UPDATE;
            default:
                return USER_MANAGEMENT_UPDATE;
        }
    }

    private String error(Sections section, BusinessLogicException e){
        e.printStackTrace();
        switch (section){
            case PERSONAL_MANAGEMENT:
                return PERSONAL_MANAGEMENT_ERROR;
            default:
                return USER_MANAGEMENT_ERROR;
        }
    }

}