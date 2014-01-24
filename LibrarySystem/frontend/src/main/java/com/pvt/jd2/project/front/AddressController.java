package com.pvt.jd2.project.front;

import com.pvt.jd2.project.common.domain.Author;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    private AuthorService addressService;

    public void setAddressService(AuthorService addressService){
        this.addressService = addressService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public String list(Model model) {
        try{
            List<Author> addresses = addressService.list();
            model.addAttribute(Attributes.ADDRESSES, addresses);
            return "list";
        }catch (BusinessLogicException e){
            return "error";
        }
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String createNew(@ModelAttribute Author address, BindingResult result) {
        return "create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute Author address, BindingResult result, Model model) {
        try{
            addressService.create(address);
            List<Author> addresses = addressService.list();
            model.addAttribute(Attributes.ADDRESSES, addresses);
            return "list";
        }catch(BusinessLogicException e){
            return "error";
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String createNew(@PathVariable Long id, Model model) {
        try{
            Author address = addressService.findById(id);
            if (address != null){
                addressService.delete(address);
            }
            List<Author> addresses = addressService.list();
            model.addAttribute(Attributes.ADDRESSES, addresses);
            return "list";
        }catch(BusinessLogicException e){
            e.printStackTrace();
            return "error";
        }
    }


}
