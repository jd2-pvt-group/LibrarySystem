package com.pvt.jd2.project.front.controllers.sections.role;

import com.pvt.jd2.project.common.domain.Permission;
import com.pvt.jd2.project.common.domain.Role;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.service.PermissionService;
import com.pvt.jd2.project.common.service.RoleService;
import com.pvt.jd2.project.front.util.Attributes;
import com.pvt.jd2.project.front.util.Parameters;
import com.pvt.jd2.project.front.util.TilesDefinitions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 02.02.14
 * Time: 6:16
 */
@Controller
@RequestMapping(value = "/management")
public class PermissionManagementController {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/permissionRole", method = RequestMethod.POST)
    public String permissionRole(@RequestParam(value = Parameters.ROLE_ID) String roleId, Model model) {
       try{
           Role role = roleService.findById(Long.valueOf(roleId));
           List<Permission> rolePermissions = permissionService.listForRole(role);
           model.addAttribute(Attributes.VIEWED_ROLE, role);
           model.addAttribute(Attributes.VIEWED_PERMISSIONS, rolePermissions);
           return TilesDefinitions.ROLE_MANAGEMENT_PERMISSIONS;
       }catch(BusinessLogicException e){
           e.printStackTrace();//TODO kick me later
           return TilesDefinitions.ROLE_MANAGEMENT_ERROR;
       }
    }

    @RequestMapping(value = "/deletePermissionRole", method = RequestMethod.POST)
    public String deletePermissionRole(@RequestParam(value = Parameters.ROLE_ID) String roleId,
                                       @RequestParam(value = Parameters.SELECTED_PERMISSIONS, required = false) String[] removePermissions,
                                       Model model) {
        try{
            Role role = roleService.findByIdFull(Long.valueOf(roleId));
            if (removePermissions != null){
                removePermissionsFromRole(role, removePermissions);
                roleService.update(role);
            }
            model.addAttribute(Attributes.VIEWED_ROLE, role);
            model.addAttribute(Attributes.VIEWED_PERMISSIONS, role.getPermissions());
            return TilesDefinitions.ROLE_MANAGEMENT_PERMISSIONS;
        }catch(BusinessLogicException e){
            e.printStackTrace();//TODO kick me later
            return TilesDefinitions.ROLE_MANAGEMENT_ERROR;
        }
    }

    private void removePermissionsFromRole(Role role, String[] removePermissions){
        List<Permission> permissions = role.getPermissions();
        for(String removePermission : removePermissions){
            if (!removePermission.isEmpty()){
                Permission permission = new Permission();
                permission.setId(Long.valueOf(removePermission));
                permissions.remove(permission);
            }
        }
    }

    @RequestMapping(value = "/addPermissionRole", method = RequestMethod.POST)
    public String addPermissionToRole(@RequestParam(value = Parameters.ROLE_ID) String roleId,
                                      Model model) {
        try{
            Role role = roleService.findById(Long.valueOf(roleId));
            List<Permission> permissions = permissionService.listNotInRole(role);
            model.addAttribute(Attributes.VIEWED_ROLE, role);
            model.addAttribute(Attributes.VIEWED_PERMISSIONS, permissions);
            return TilesDefinitions.ROLE_MANAGEMENT_ADD_PERMISSIONS;
        }catch(BusinessLogicException e){
            e.printStackTrace();//TODO kick me later
            return TilesDefinitions.ROLE_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/changePermissionRole", method = RequestMethod.POST)
    public String changePermissionRole(@RequestParam(value = Parameters.ROLE_ID) String roleId,
                                       @RequestParam(value = Parameters.SELECTED_PERMISSIONS, required = false)String[] addPermissions,
                                       Model model){
        try{
            Role role = roleService.findByIdFull(Long.valueOf(roleId));
            if (addPermissions != null){
                List<Permission> permissions = getAddPermissions(addPermissions);
                role.getPermissions().addAll(permissions);
                roleService.update(role);
            }
            List<Permission> viewedPermissions = permissionService.listNotInRole(role);
            model.addAttribute(Attributes.VIEWED_ROLE, role);
            model.addAttribute(Attributes.VIEWED_PERMISSIONS, viewedPermissions);
            return TilesDefinitions.ROLE_MANAGEMENT_ADD_PERMISSIONS;
        }catch(BusinessLogicException e){
            e.printStackTrace();//TODO kick me later
            return TilesDefinitions.ROLE_MANAGEMENT_ERROR;
        }
    }

    private List<Permission> getAddPermissions(String[] addPermissions) throws BusinessLogicException {
        List<Permission> permissions = new ArrayList<Permission>();
        for(String addPermission : addPermissions){
            if (!addPermission.isEmpty()){
                permissions.add(permissionService.findById(Long.valueOf(addPermission)));
            }
        }
        return permissions;
    }

}
