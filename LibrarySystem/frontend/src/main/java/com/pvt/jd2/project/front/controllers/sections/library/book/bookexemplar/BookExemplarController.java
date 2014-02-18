package com.pvt.jd2.project.front.controllers.sections.library.book.bookexemplar;

import com.pvt.jd2.project.common.domain.ActivationStatus;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.BookExemplar;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.service.BookExemplarService;
import com.pvt.jd2.project.common.service.BookService;
import com.pvt.jd2.project.front.controllers.sections.library.CommonLogic;
import com.pvt.jd2.project.front.controllers.sections.library.book.types.BookActionType;
import com.pvt.jd2.project.front.formbeans.FindBookExemplar;
import com.pvt.jd2.project.front.util.Attributes;
import com.pvt.jd2.project.front.util.Parameters;
import com.pvt.jd2.project.front.util.TilesDefinitions;
import com.pvt.jd2.project.front.validators.BookExemplarValidator;
import com.pvt.jd2.project.front.validators.find.FindBookExemplarValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 06.02.14
 * Time: 7:10
 */
@Controller
@RequestMapping(value = "/management")
public class BookExemplarController extends CommonLogic {

    @Autowired
    private BookExemplarService bookExemplarService;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookExemplarValidator bookExemplarValidator;

    @Autowired
    private FindBookExemplarValidator findBookExemplarValidator;

    @RequestMapping(value = "/addBookExemplar", method = RequestMethod.GET)
    public String addBook(Model model, HttpSession session){
        BookExemplar formBean = buildBookExemplar(session);
        model.addAttribute(Attributes.VIEWED_BOOK_EXEMPLAR_FLOW, formBean);
        return TilesDefinitions.LIBRARY_BOOK_EXEMPLAR_MANAGEMENT_ADD;
    }

    @ModelAttribute(value = Attributes.VIEWED_BOOK_EXEMPLAR_FLOW)
    private BookExemplar buildBookExemplar(HttpSession session){
        BookExemplar formBean = getBookExemplar(session);
        if (formBean == null){
            formBean = new BookExemplar();
            session.setAttribute(Attributes.VIEWED_BOOK_EXEMPLAR_FLOW, formBean);
        }
        return formBean;
    }

    @RequestMapping(value = "/addNewBookExemplar", method = RequestMethod.POST)
    public String addNewBook(@ModelAttribute(value = Attributes.VIEWED_BOOK_EXEMPLAR_FLOW) BookExemplar bookExemplar,
                             Model model, BindingResult result, HttpSession session,
                             @RequestParam(value = Parameters.BOOK_ADD_ACTION) String bookAddAction){
        try{
            return performCreationOfNewBook(bookExemplar, bookAddAction, result, model, session);
        }catch(BusinessLogicException e){
            e.printStackTrace();
            return TilesDefinitions.LIBRARY_BOOK_EXEMPLAR_MANAGEMENT_ERROR;
        }
    }

    private BookExemplar getBookExemplar(HttpSession session) {
        return (BookExemplar)session.getAttribute(Attributes.VIEWED_BOOK_EXEMPLAR_FLOW);
    }

    private String performCreationOfNewBook(BookExemplar bookExemplar,
                                String bookAddAction, BindingResult result,
                                Model model, HttpSession session) throws BusinessLogicException {
        BookActionType action = BookActionType.valueOf(bookAddAction);
        String commonAction = selectCommonTilesDefinition(action, model);
        if (commonAction != null){
            return commonAction;
        }
        ValidationUtils.invokeValidator(bookExemplarValidator, bookExemplar, result);
        if (result.hasErrors()){
            return TilesDefinitions.LIBRARY_BOOK_EXEMPLAR_MANAGEMENT_ADD;
        }
        bookExemplarService.create(bookExemplar);
        model.addAttribute(Attributes.VIEWED_BOOK_EXEMPLAR, bookExemplar);
        session.removeAttribute(Attributes.VIEWED_BOOK_EXEMPLAR_FLOW);
        return TilesDefinitions.LIBRARY_BOOK_EXEMPLAR_MANAGEMENT_INFO;
    }

    @RequestMapping(value = "/addBookTypeToBookExemplar", method = RequestMethod.POST)
    public String addBookTypeToBookExemplar(Model model, HttpSession session,
                                            @RequestParam(value = Parameters.BOOK_TYPE_ID) String bookTypeId) {
        try{
            BookExemplar bookExemplar = getBookExemplar(session);
            Book book = bookService.findByIdFull(Long.valueOf(bookTypeId));
            bookExemplar.setBook(book);
            model.addAttribute(Attributes.VIEWED_BOOK_EXEMPLAR_FLOW, bookExemplar);
            return TilesDefinitions.LIBRARY_BOOK_EXEMPLAR_MANAGEMENT_ADD;
        }catch(BusinessLogicException e){
            e.printStackTrace();//TODO kill me
            return TilesDefinitions.LIBRARY_BOOK_EXEMPLAR_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/listBookExemplars", method = RequestMethod.GET)
    public String listBooks(Model model){
        try{
            List<BookExemplar> bookExemplars = bookExemplarService.list(ActivationStatus.ALL);
            model.addAttribute(Attributes.VIEWED_BOOK_EXEMPLARS, bookExemplars);
            return TilesDefinitions.LIBRARY_BOOK_EXEMPLAR_MANAGEMENT_LIST;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_BOOK_EXEMPLAR_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/infoBookExemplar", method = RequestMethod.POST)
    public String infoBookExemplar(Model model,
                                   @RequestParam(value = Parameters.BOOK_EXEMPLAR_ID) String bookExemplarId) {
        try{
            BookExemplar formBean = getBookExemplar(Long.valueOf(bookExemplarId));
            model.addAttribute(Attributes.VIEWED_BOOK_EXEMPLAR, formBean);
            return TilesDefinitions.LIBRARY_BOOK_EXEMPLAR_MANAGEMENT_INFO;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_BOOK_EXEMPLAR_MANAGEMENT_ERROR;
        }
    }

    private BookExemplar getBookExemplar(Long bookExemplarId) {
        BookExemplar bookExemplar = bookExemplarService.findById(bookExemplarId);
        Book book = bookService.findByIdFull(bookExemplar.getBook().getId());
        bookExemplar.setBook(book);
        return bookExemplar;
    }

    @RequestMapping(value = "/updateBookExemplar", method = RequestMethod.POST)
    public String updateBookExemplar(Model model, HttpSession session,
                                     @RequestParam(value = Parameters.BOOK_EXEMPLAR_ID) String bookExemplarId){
        try{
            BookExemplar formBean = getBookExemplar(Long.valueOf(bookExemplarId));
            session.setAttribute(Attributes.VIEWED_BOOK_EXEMPLAR_FLOW, formBean);
            model.addAttribute(Attributes.VIEWED_BOOK_EXEMPLAR, formBean);
            return TilesDefinitions.LIBRARY_BOOK_EXEMPLAR_MANAGEMENT_UPDATE;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_BOOK_EXEMPLAR_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/changeBookExemplar", method = RequestMethod.POST)
    public String changeBookExemplar(@ModelAttribute(value = Attributes.VIEWED_BOOK_EXEMPLAR) BookExemplar formBean,
                                     BindingResult result, Model model, HttpSession session){
        BookExemplar bookExemplar = (BookExemplar)session.getAttribute(Attributes.VIEWED_BOOK_EXEMPLAR_FLOW);
        updateFormBean(formBean, bookExemplar);
        try{
            ValidationUtils.invokeValidator(bookExemplarValidator, formBean, result);
            if (result.hasErrors()){
                return TilesDefinitions.LIBRARY_BOOK_EXEMPLAR_MANAGEMENT_UPDATE;
            }
            bookExemplarService.update(formBean);
            model.addAttribute(Attributes.VIEWED_BOOK_EXEMPLAR, formBean);
            session.removeAttribute(Attributes.VIEWED_BOOK_EXEMPLAR_FLOW);
            return TilesDefinitions.LIBRARY_BOOK_EXEMPLAR_MANAGEMENT_INFO;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_BOOK_EXEMPLAR_MANAGEMENT_ERROR;
        }
    }

    private void updateFormBean(BookExemplar formBean, BookExemplar bookExemplar){
        formBean.setId(bookExemplar.getId());
        formBean.setBook(bookExemplar.getBook());
    }

    @RequestMapping(value = "/deleteBookExemplar", method = RequestMethod.POST)
    public String deleteBookExemplar(Model model,
                                     @RequestParam(value = Parameters.BOOK_EXEMPLAR_ID) String bookExemplarId){
        try{
            BookExemplar bookExemplar = bookExemplarService.findById(Long.valueOf(bookExemplarId));
            bookExemplarService.delete(bookExemplar);
            List<BookExemplar> bookExemplars = bookExemplarService.list(ActivationStatus.ALL);
            model.addAttribute(Attributes.VIEWED_BOOK_EXEMPLARS, bookExemplars);
            return TilesDefinitions.LIBRARY_BOOK_EXEMPLAR_MANAGEMENT_LIST;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_BOOK_EXEMPLAR_MANAGEMENT_ERROR;
        }
    }

    @ModelAttribute(value = Attributes.ACTIVATION_STATUSES)
    private ActivationStatus[]  getActivationStatuses(){
        return getActivationStatusesArray();
    }

    @RequestMapping(value = "/findBookExemplar", method = RequestMethod.GET)
    public String findBookExemplar(@ModelAttribute(value = Attributes.ACTIVATION_STATUSES) ActivationStatus[] statuses,
                                   @ModelAttribute(value = Attributes.VIEWED_BOOK_EXEMPLAR) FindBookExemplar formBean){
        return TilesDefinitions.LIBRARY_BOOK_EXEMPLAR_MANAGEMENT_FIND;
    }

    @RequestMapping(value = "/foundBookExemplars", method = RequestMethod.POST)
    public String foundBookExemplar(@ModelAttribute(value = Attributes.ACTIVATION_STATUSES) ActivationStatus[] statuses,
                                    @ModelAttribute(value = Attributes.VIEWED_BOOK_EXEMPLAR) FindBookExemplar formBean,
                                    BindingResult result, Model model){

        try{
            ValidationUtils.invokeValidator(findBookExemplarValidator, formBean, result);
            if (result.hasErrors()){
                return TilesDefinitions.LIBRARY_BOOK_EXEMPLAR_MANAGEMENT_FIND;
            }
            List<BookExemplar> bookExemplars = bookExemplarService.listLike(formBean.getBookExemplar(), formBean.getStatus());
            model.addAttribute(Attributes.VIEWED_BOOK_EXEMPLARS, bookExemplars);
            return TilesDefinitions.LIBRARY_BOOK_EXEMPLAR_MANAGEMENT_LIST;
        }catch (BusinessLogicException e){
            e.printStackTrace(); //TODO kick me
            return TilesDefinitions.LIBRARY_BOOK_EXEMPLAR_MANAGEMENT_ERROR;
        }
    }

}
