package com.pvt.jd2.project.front.controllers.sections.role;

import com.pvt.jd2.project.common.domain.Role;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.service.RoleService;
import com.pvt.jd2.project.front.comparators.RoleDataComparator;
import com.pvt.jd2.project.front.util.Attributes;
import com.pvt.jd2.project.front.util.Parameters;
import com.pvt.jd2.project.front.util.TilesDefinitions;
import com.pvt.jd2.project.front.validators.find.FindRoleValidator;
import com.pvt.jd2.project.front.validators.RoleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 29.01.14
 * Time: 20:50
 */
@Controller
@RequestMapping(value = "/management")
public class RoleManagementController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleValidator roleValidator;

    @Autowired
    private FindRoleValidator findRoleValidator;

    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
    public String addRole(@ModelAttribute(value = Attributes.VIEWED_ROLE) Role viewedRole,
                          BindingResult result){
        return TilesDefinitions.ROLE_MANAGEMENT_ADD;
    }

    @RequestMapping(value = "/addNewRole", method = RequestMethod.POST)
    public String addNewRole(@ModelAttribute(value = Attributes.VIEWED_ROLE) Role viewedRole,
                             BindingResult result){
        ValidationUtils.invokeValidator(roleValidator, viewedRole, result);
        if (result.hasErrors()){
            return TilesDefinitions.ROLE_MANAGEMENT_ADD;
        }
        try{
            roleService.create(viewedRole);
            return TilesDefinitions.ROLE_MANAGEMENT_INFO;
        }catch(BusinessLogicException e){
            e.printStackTrace(); //TODO kill me
            return TilesDefinitions.ROLE_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/infoRole", method = RequestMethod.POST)
    public String infoRole(@RequestParam(value = Parameters.ROLE_ID) String  roleId, Model model) {
        try{
            Role role = roleService.findById(Long.valueOf(roleId));
            model.addAttribute(Attributes.VIEWED_ROLE, role);
            return TilesDefinitions.ROLE_MANAGEMENT_INFO;
        }catch(BusinessLogicException e){
            e.printStackTrace(); //TODO kill me
            return TilesDefinitions.ROLE_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/updateRole", method = RequestMethod.POST)
    public String updateRole(@RequestParam(value = Parameters.ROLE_ID) String roleId,
                             Model model){
        try{
            Role viewedRole = roleService.findById(Long.valueOf(roleId));
            model.addAttribute(Attributes.VIEWED_ROLE, viewedRole);
            return TilesDefinitions.ROLE_MANAGEMENT_UPDATE;
        }catch (BusinessLogicException e){
            e.printStackTrace(); //TODO kill me
            return TilesDefinitions.ROLE_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/changeRole", method = RequestMethod.POST)
    public String changeRole(@ModelAttribute(value = Attributes.VIEWED_ROLE) Role viewedRole,
                             BindingResult result){
        ValidationUtils.invokeValidator(roleValidator, viewedRole, result);
        if (result.hasErrors()){
            return TilesDefinitions.ROLE_MANAGEMENT_UPDATE;
        }
        try{
            Role existedRole = roleService.findByIdFull(viewedRole.getId());
            RoleDataComparator comparator = new RoleDataComparator();
            if (!comparator.compare(existedRole, viewedRole)){
                viewedRole.setPermissions(existedRole.getPermissions());
                roleService.update(viewedRole);
            }
            return TilesDefinitions.ROLE_MANAGEMENT_INFO;
        }catch(BusinessLogicException e){
            e.printStackTrace(); //TODO kill me
            return TilesDefinitions.ROLE_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/listRoles")
    public String listRoles(Model model){
        try{
            List<Role> roles = roleService.list();
            model.addAttribute(Attributes.VIEWED_ROLES, roles);
            return TilesDefinitions.ROLE_MANAGEMENT_LIST;
        }catch(BusinessLogicException e){
            e.printStackTrace(); //TODO kill me
            return TilesDefinitions.ROLE_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/findRole", method = RequestMethod.POST)
    public String findRole(@ModelAttribute(value = Attributes.VIEWED_ROLE) Role findRole,
                           BindingResult result){
        return TilesDefinitions.ROLE_MANAGEMENT_FIND;
    }

    @RequestMapping(value = "/foundRoles", method = RequestMethod.POST)
    public String foundRoles(@ModelAttribute(value = Attributes.VIEWED_ROLE) Role findRole,
                             BindingResult result, Model model){
        ValidationUtils.invokeValidator(findRoleValidator, findRole, result);
        if (result.hasErrors()){
            return TilesDefinitions.ROLE_MANAGEMENT_FIND;
        }
        try{
            return findRole(findRole, model);
        }catch(BusinessLogicException e){
            e.printStackTrace(); //TODO kill me
            return TilesDefinitions.ROLE_MANAGEMENT_ERROR;
        }
    }

    private String findRole(Role findRole, Model model) {
        List<Role> roles = roleService.listLike(findRole);
        model.addAttribute(Attributes.VIEWED_ROLES, roles);
        return TilesDefinitions.ROLE_MANAGEMENT_LIST;
    }

}
