package com.pvt.jd2.project.front.controllers.sections.library.book.bookserial;

import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.BookSerial;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.service.BookSerialService;
import com.pvt.jd2.project.front.util.Attributes;
import com.pvt.jd2.project.front.util.NavigateOnPage;
import com.pvt.jd2.project.front.util.Parameters;
import com.pvt.jd2.project.front.util.TilesDefinitions;
import com.pvt.jd2.project.front.validators.BookSerialValidator;
import com.pvt.jd2.project.front.validators.find.FindBookSerialValidator;
import com.pvt.jd2.project.front.validators.generic.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 04.02.14
 * Time: 10:55
 */
@Controller
@SessionAttributes(value = {
        Attributes.VIEWED_BOOK_TYPE_FLOW
})
@RequestMapping(value = "/management")
public class BookSerialManagementController {

    @Autowired
    private BookSerialValidator bookSerialValidator;

    @Autowired
    private FindBookSerialValidator findBookSerialValidator;

    @Autowired
    private BookSerialService bookSerialService;

    @RequestMapping(value = "/addBookSerial", method = RequestMethod.GET)
    public String addBookSerial(@ModelAttribute(value = Attributes.VIEWED_BOOK_SERIAL) BookSerial bookSerial) {
        return TilesDefinitions.LIBRARY_BOOK_SERIAL_MANAGEMENT_ADD;
    }

    @RequestMapping(value = "/addNewBookSerial", method = RequestMethod.POST)
    public String addNewBookSerial(@ModelAttribute(value = Attributes.VIEWED_BOOK_SERIAL) BookSerial bookSerial,
                                BindingResult result) {
        try{
            ValidationUtils.invokeValidator(bookSerialValidator, bookSerial, result);
            if (result.hasErrors()){
                return TilesDefinitions.LIBRARY_BOOK_SERIAL_MANAGEMENT_ADD;
            }
            bookSerialService.create(bookSerial);
            return TilesDefinitions.LIBRARY_BOOK_SERIAL_MANAGEMENT_INFO;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_BOOK_SERIAL_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/listBookSerials", method = RequestMethod.GET)
    public String listOfBookSerials(Model model){
        List<BookSerial> bookSerials = bookSerialService.list();
        model.addAttribute(Attributes.VIEWED_BOOK_SERIALS, bookSerials);
        return TilesDefinitions.LIBRARY_BOOK_SERIAL_MANAGEMENT_LIST;
    }

    @RequestMapping(value = "/addBookSerialToBookType", method = RequestMethod.POST)
    public String addToBookType(@ModelAttribute(value = Attributes.VIEWED_BOOK_TYPE_FLOW) Book viewedBookType,
                                @RequestParam(value = Parameters.BOOK_SERIAL_ID) String bookSerialId) {
        BookSerial bookSerial = bookSerialService.findById(Long.valueOf(bookSerialId));
        viewedBookType.setBookSerial(bookSerial);
        if (viewedBookType.getId() == null){
            return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_ADD;
        }else{
            return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_UPDATE;
        }
    }

    @RequestMapping(value = "/deleteBookSerial", method = RequestMethod.POST)
    public String deleteBookSerial(@RequestParam(value = Parameters.BOOK_SERIAL_ID) String bookSerialId,
                                   Model model){
        try{
            BookSerial bookSerial = bookSerialService.findById(Long.valueOf(bookSerialId));
            bookSerialService.delete(bookSerial);
            List<BookSerial> bookSerials = bookSerialService.list();
            model.addAttribute(Attributes.VIEWED_BOOK_SERIALS, bookSerials);
            return TilesDefinitions.LIBRARY_BOOK_SERIAL_MANAGEMENT_LIST;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_BOOK_SERIAL_MANAGEMENT_ERROR;
        }
    }
    @RequestMapping(value = "/findBookSerial", method = RequestMethod.GET)
    private String findBookSerial(@ModelAttribute(value = Attributes.VIEWED_BOOK_SERIAL) BookSerial formBean){
        return TilesDefinitions.LIBRARY_BOOK_SERIAL_MANAGEMENT_FIND;
    }

    @RequestMapping(value = "/foundBookSerials", method = RequestMethod.POST)
    private String findBookSerial(@ModelAttribute(value = Attributes.VIEWED_BOOK_SERIAL) BookSerial formBean,
                                  BindingResult result,
                                  Model model) {
        try{
            ValidationUtils.invokeValidator(findBookSerialValidator, formBean, result);
            if (result.hasErrors()){
                return TilesDefinitions.LIBRARY_BOOK_SERIAL_MANAGEMENT_FIND;
            }
            return findBookSerial(formBean, model);
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_BOOK_SERIAL_MANAGEMENT_ERROR;
        }
    }

    private String findBookSerial(BookSerial formBean, Model model) throws BusinessLogicException {
        List<BookSerial> bookSerials = bookSerialService.listLike(formBean);
        model.addAttribute(Attributes.VIEWED_BOOK_SERIALS, bookSerials);
        return TilesDefinitions.LIBRARY_BOOK_SERIAL_MANAGEMENT_LIST;
    }

    @RequestMapping(value = "/infoBookSerial", method = RequestMethod.POST)
    public String infoBookSerial(@RequestParam(value = Parameters.BOOK_SERIAL_ID) String bookSerialId, Model model) {
        try{
            BookSerial bookSerial = bookSerialService.findById(Long.valueOf(bookSerialId));
            model.addAttribute(Attributes.VIEWED_BOOK_SERIAL, bookSerial);
            return TilesDefinitions.LIBRARY_BOOK_SERIAL_MANAGEMENT_INFO;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_BOOK_SERIAL_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/updateBookSerial", method = RequestMethod.POST)
    public String updateBookSerial(@RequestParam(value = Parameters.BOOK_SERIAL_ID) String bookSerialId, Model model){
        try{
            BookSerial bookSerial = bookSerialService.findById(Long.valueOf(bookSerialId));
            model.addAttribute(Attributes.VIEWED_BOOK_SERIAL, bookSerial);
            return TilesDefinitions.LIBRARY_BOOK_SERIAL_MANAGEMENT_UPDATE;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_BOOK_SERIAL_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/changeBookSerial", method = RequestMethod.POST)
    public String changeBookSerial(HttpSession session, @ModelAttribute(value = Attributes.VIEWED_BOOK_SERIAL) BookSerial bookSerial,
                                   BindingResult result) {
        try{
            ValidationUtils.invokeValidator(bookSerialValidator, bookSerial, result);
            if (result.hasErrors()){
                return TilesDefinitions.LIBRARY_BOOK_SERIAL_MANAGEMENT_UPDATE;
            }
            Book viewedBookType = (Book)session.getAttribute(Attributes.VIEWED_BOOK_TYPE_FLOW);
            updateBookSerialOfBookTypeFlow(viewedBookType, bookSerial);
            bookSerialService.update(bookSerial);
            return TilesDefinitions.LIBRARY_BOOK_SERIAL_MANAGEMENT_INFO;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_BOOK_SERIAL_MANAGEMENT_ERROR;
        }
    }

    private void updateBookSerialOfBookTypeFlow(Book bookType, BookSerial bookSerial) {
        if (bookType != null){
            BookSerial selectedBookSerial = bookType.getBookSerial();
            if (selectedBookSerial != null){
                bookType.setBookSerial(bookSerial);
            }
        }

    }

    @RequestMapping(value = "/removeSelectedBookSerial", method = RequestMethod.POST)
    public String removeSelectedBookSerial(@ModelAttribute(value = Attributes.VIEWED_BOOK_SERIAL) BookSerial formBean,
                                           @ModelAttribute(value = Attributes.VIEWED_BOOK_TYPE_FLOW) Book viewedBookType,
                                           @RequestParam(value = Parameters.BOOK_SERIAL_ID, required = false) String bookSerialId,
                                           @RequestParam(value = Parameters.ON_PAGE) String onPage,
                                           Model model) {
        BookSerial viewedBookSerial = viewedBookType.getBookSerial();
        if (viewedBookSerial != null){
            viewedBookType.setBookSerial(null);
        }
        try{
            if (bookSerialId != null){
                BookSerial bookSerial = bookSerialService.findById(Long.valueOf(bookSerialId));
                model.addAttribute(Attributes.VIEWED_BOOK_SERIAL, bookSerial);
            }
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_BOOK_SERIAL_MANAGEMENT_ERROR;
        }
        return gotTo(onPage);
    }

    private String gotTo(String onPage) {
        NavigateOnPage page = NavigateOnPage.valueOf(onPage);
        switch(page){
            case INFO:
                return TilesDefinitions.LIBRARY_BOOK_SERIAL_MANAGEMENT_INFO;
            case LIST:
                return TilesDefinitions.LIBRARY_BOOK_SERIAL_MANAGEMENT_LIST;
            case ADD:
                return TilesDefinitions.LIBRARY_BOOK_SERIAL_MANAGEMENT_ADD;
            case FIND:
                return TilesDefinitions.LIBRARY_BOOK_SERIAL_MANAGEMENT_FIND;
            default:
                return TilesDefinitions.LIBRARY_BOOK_SERIAL_MANAGEMENT_ERROR;
        }
    }

}
