package com.pvt.jd2.project.front.controllers.sections.user;

import com.pvt.jd2.project.common.domain.Role;
import com.pvt.jd2.project.common.domain.User;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.service.RoleService;
import com.pvt.jd2.project.common.service.UserService;
import com.pvt.jd2.project.front.util.Attributes;
import com.pvt.jd2.project.front.util.Parameters;
import com.pvt.jd2.project.front.util.Sections;
import com.pvt.jd2.project.front.util.TilesDefinitions;
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
    private RoleService roleService;

    @Autowired
    private UserValidator userValidator;
    @Autowired
    private FindUserValidator findUserValidator;



    @RequestMapping(value = "/addRoleUser", method = RequestMethod.POST)
    public String addRolesUser(@RequestParam(value = Parameters.USER_ID) String userId,

                             Model model,
                             @ModelAttribute(value = Attributes.SECTION) Sections section) {


        try{


            List <Role> roleList = roleService.list();

            model.addAttribute(Attributes. VIEWED_ROLES, roleList);

            return USER_MANAGEMENT_ADD_ROLE;

        }catch(BusinessLogicException e){
            return error(section, e);
        }
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String createUser(@ModelAttribute(value = Attributes.VIEWED_USER) User viewedUser,
                          BindingResult result,
                          Model model,
                          @ModelAttribute(value = Attributes.SECTION) Sections section) {
      ValidationUtils.invokeValidator(userValidator, viewedUser, result);

        try{
            if (result.hasErrors()){
                return USER_MANAGEMENT_ADD;
            }
            System.out.println(viewedUser);

           return successUserCreate(section,viewedUser,model);

        }catch(BusinessLogicException e){
            return error(section, e);
        }
    }


    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser(@ModelAttribute(value = Attributes.VIEWED_USER) User viewedUser,
                          BindingResult result,
                          @ModelAttribute(value = Attributes.SECTION) Sections section) {

        return successUserAdd(section);
    }

    @RequestMapping(value = "/listUsers",method = RequestMethod.GET)
    public String listUsers(
            @ModelAttribute(value = Attributes.SECTION) Sections section, Model model){
        List<User> listViewedUser= null ;
        return successUsersList(section, listViewedUser,model );
    }

    @RequestMapping(value = "/findUser",method = RequestMethod.GET)
    public String findUser( @ModelAttribute(value = Attributes.VIEWED_USER) User viewedUser,
                           BindingResult result,
                           @ModelAttribute(value = Attributes.SECTION) Sections section) {

          //  updateModelWithUser(Long.valueOf(userId), model);
            return successUserFind(section);

    }

    @RequestMapping(value = "/foundUsers",method = RequestMethod.POST)
    public String foundUsers(@ModelAttribute(value = Attributes.VIEWED_USER) User viewedUser,
                             BindingResult result,
                             @ModelAttribute(value = Attributes.SECTION) Sections section,Model model) {
        ValidationUtils.invokeValidator(findUserValidator, viewedUser, result);
        if(result.hasErrors()){
             return USER_MANAGEMENT_FIND;
        }
        try{
            List<User> foundList = userService.listLike(viewedUser);
            model.addAttribute(Attributes.VIEWED_USERS,foundList);
            return USER_MANAGEMENT_LIST;
        } catch (BusinessLogicException e) {
            e.printStackTrace(); //TODO kill me
            return USER_MANAGEMENT_ERROR;
        }
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
            userService.update(viewedUser);
            return successInfoUser(section);
        }catch(BusinessLogicException e){
            return error(section, e);
        }
    }

    private void updateModelWithUser(Long userId, Model model) throws BusinessLogicException {
        User viewedUser = userService.findById(userId);
        List <Role> roleList = roleService.listForUser(viewedUser);
        model.addAttribute(Attributes.VIEWED_USER, viewedUser);
        model.addAttribute(Attributes. VIEWED_ROLES, roleList);

    }


    private String successUserAdd(Sections section){
        switch (section){
            case USER_MANAGEMENT:
                return USER_MANAGEMENT_ADD;
            default:
                return USER_MANAGEMENT_INFO;
        }
    }
    private String successUserCreate(Sections section,User user,Model model) throws BusinessLogicException {
        switch (section){
            case USER_MANAGEMENT:
                user.setActive(true);
          user = userService.create(user);
                updateModelWithUser(user.getId(),model);
                return USER_MANAGEMENT_INFO;
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
