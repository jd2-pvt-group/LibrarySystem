package com.pvt.jd2.project.front;

import com.pvt.jd2.project.common.domain.Address;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 20:22
 */
@Controller
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public String list(Model model) {
        try{
            List<Address> addresses = addressService.list();
            model.addAttribute(Attributes.ADDRESSES, addresses);
            return "/WEB-INF/pages/list.jsp";
        }catch (BusinessLogicException e){
            return "/WEB-INF/pages/error.jsp";
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute Address address) {
        try{
            addressService.create(address);
            return "/WEB-INF/pages/list.jsp";
        }catch (BusinessLogicException e){
            return "/WEB-INF/pages/error.jsp";
        }
    }

}
