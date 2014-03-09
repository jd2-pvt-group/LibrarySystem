package com.pvt.jd2.project.front.controllers.sections.library.book.booktype;

import com.pvt.jd2.project.common.domain.*;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.service.*;
import com.pvt.jd2.project.front.controllers.sections.library.CommonLogic;
import com.pvt.jd2.project.front.controllers.sections.library.book.types.BookActionType;
import com.pvt.jd2.project.front.controllers.sections.library.book.types.BookTypeInfoStatusType;
import com.pvt.jd2.project.front.util.Attributes;
import com.pvt.jd2.project.front.util.Parameters;
import com.pvt.jd2.project.front.util.TilesDefinitions;
import com.pvt.jd2.project.front.validators.BookValidator;
import com.pvt.jd2.project.front.validators.find.FindBookValidator;
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
 * Time: 9:22
 */
@Controller
@RequestMapping(value = "/management")
public class BookTypeManagementController extends CommonLogic {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookValidator bookValidator;

    @Autowired
    private FindBookValidator findBookValidator;

    @Autowired
    private BookSerialService bookSerialService;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private GenreService genreService;

    @ModelAttribute(value = Attributes.VIEWED_BOOK_TYPE_FLOW)
    public Book buildViewedBookType(HttpSession session){
        Book book = (Book)session.getAttribute(Attributes.VIEWED_BOOK_TYPE_FLOW);
        if (book == null){
            book = new Book();
            session.setAttribute(Attributes.VIEWED_BOOK_TYPE_FLOW, book);
        }
        return book;
    }

    @RequestMapping(value = "/addBookType", method = RequestMethod.GET)
    public String createBookType(@ModelAttribute(value = Attributes.VIEWED_BOOK_TYPE_FLOW) Book viewedBookType) {
        return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_ADD;
    }

    @RequestMapping(value = "/addNewBookType", method = RequestMethod.POST)
    public String createNewBookType(@ModelAttribute(value = Attributes.VIEWED_BOOK_TYPE_FLOW) Book viewedBookType,
                                    BindingResult result, Model model, HttpSession session,
                                    @RequestParam(value = Parameters.BOOK_ADD_ACTION) String bookAddAction) {
        String commonAction = getBookAction(bookAddAction, model);
        if (commonAction != null){
            return commonAction;
        }
        try{
            return creationOfNewBook(viewedBookType, result,
                    model, session, bookAddAction);
        }catch(BusinessLogicException e){
           return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_ERROR;
        }
    }

    private String creationOfNewBook(Book viewedBookType, BindingResult result,
                                     Model model, HttpSession session, String bookAddAction) throws BusinessLogicException {
        ValidationUtils.invokeValidator(bookValidator, viewedBookType, result);
        if (result.hasErrors()){
            return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_ADD;
        }
        bookService.create(viewedBookType);
        session.removeAttribute(Attributes.VIEWED_BOOK_TYPE_FLOW);
        model.addAttribute(Attributes.VIEWED_BOOK_TYPE, viewedBookType);
        return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_INFO;
    }

    @RequestMapping(value = "/infoBookType", method = RequestMethod.POST)
    public String infoBookType(Model model,
                               @RequestParam(value = Parameters.BOOK_TYPE_ID) String bookTypeId) {
        try{
            Book book = (Book)bookService.findById(Long.valueOf(bookTypeId));
            model.addAttribute(Attributes.VIEWED_BOOK_TYPE, book);
            return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_INFO;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/deleteBookType", method = RequestMethod.POST)
    public String deleteBookType(Model model,
                                 @RequestParam(value = Parameters.BOOK_TYPE_ID) String bookTypeId) {
        try{
            Book book = (Book)bookService.findById(Long.valueOf(bookTypeId));
            bookService.delete(book);
            List<Book> books = bookService.list();
            model.addAttribute(Attributes.VIEWED_BOOK_TYPES, books);
            return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_LIST;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/listBookTypes", method = RequestMethod.GET)
    public String listBookTypes(Model model){
        try{
            List<Book> books = bookService.list();
            model.addAttribute(Attributes.VIEWED_BOOK_TYPES, books);
            return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_LIST;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/viewBookSerial", method = RequestMethod.POST)
    public String viewBookType(Model model,
                               @RequestParam(value = Parameters.BOOK_TYPE_ID) String bookTypeId){
        try{
            Book book = (Book)bookService.findById(Long.valueOf(bookTypeId));
            BookSerial bookSerial = bookSerialService.findFor(book);
            model.addAttribute(Attributes.INFO_STATUS, BookTypeInfoStatusType.BOOK_SERIAL);
            model.addAttribute(Attributes.VIEWED_BOOK_SERIAL, bookSerial);
            model.addAttribute(Attributes.VIEWED_BOOK_TYPE, book);
            return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_INFO;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/viewPublisher", method = RequestMethod.POST)
    public String viewPublisher(Model model,
                                @RequestParam(value = Parameters.BOOK_TYPE_ID) String bookTypeId) {
        try{
            Book book = (Book)bookService.findById(Long.valueOf(bookTypeId));
            Publisher publisher = publisherService.findFor(book);
            model.addAttribute(Attributes.INFO_STATUS, BookTypeInfoStatusType.PUBLISHER);
            model.addAttribute(Attributes.VIEWED_PUBLISHER, publisher);
            model.addAttribute(Attributes.VIEWED_BOOK_TYPE, book);
            return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_INFO;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/viewAuthors", method = RequestMethod.POST)
    public String viewAuthors(Model model,
                                @RequestParam(value = Parameters.BOOK_TYPE_ID) String bookTypeId) {
        try{
            Book book = (Book)bookService.findById(Long.valueOf(bookTypeId));
            List<Author> authors = authorService.findFor(book);
            model.addAttribute(Attributes.INFO_STATUS, BookTypeInfoStatusType.AUTHORS);
            model.addAttribute(Attributes.VIEWED_AUTHORS, authors);
            model.addAttribute(Attributes.VIEWED_BOOK_TYPE, book);
            return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_INFO;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/viewGenres", method = RequestMethod.POST)
    public String viewGenres(Model model,
                              @RequestParam(value = Parameters.BOOK_TYPE_ID) String bookTypeId) {
        try{
            Book book = (Book)bookService.findById(Long.valueOf(bookTypeId));
            List<Genre> genres = genreService.findFor(book);
            model.addAttribute(Attributes.INFO_STATUS, BookTypeInfoStatusType.GENRES);
            model.addAttribute(Attributes.VIEWED_GENRES, genres);
            model.addAttribute(Attributes.VIEWED_BOOK_TYPE, book);
            return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_INFO;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/findBookType", method = RequestMethod.GET)
    public String findBookType(@ModelAttribute(value = Attributes.VIEWED_BOOK_TYPE) Book formBean) {
        return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_FIND;
    }

    @RequestMapping(value = "/foundBookType", method = RequestMethod.POST)
    public String foundBookType(@ModelAttribute(value = Attributes.VIEWED_BOOK_TYPE) Book formBean,
                               BindingResult result, Model model) {
        ValidationUtils.invokeValidator(findBookValidator, formBean, result);
        if (result.hasErrors()){
            return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_FIND;
        }
        try{
            List<Book> books = bookService.listLike(formBean);
            model.addAttribute(Attributes.VIEWED_BOOK_TYPES, books);
            return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_LIST;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/updateBookType", method = RequestMethod.POST)
    public String updateBookType(Model model, HttpSession session,
                                 @RequestParam(value = Parameters.BOOK_TYPE_ID) String bookTypeId){
        try{
            Book book = bookService.findByIdFull(Long.valueOf(bookTypeId));
            model.addAttribute(Attributes.VIEWED_BOOK_TYPE_FLOW, book);
            session.setAttribute(Attributes.VIEWED_BOOK_TYPE_FLOW, book);
            return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_UPDATE;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/changeBookType", method = RequestMethod.POST)
    public String changeBookType(@ModelAttribute(value = Attributes.VIEWED_BOOK_TYPE_FLOW) Book book,
                                 BindingResult result, Model model,
                                 @RequestParam(value = Parameters.BOOK_ADD_ACTION) String bookAddAction){
        String commonAction = getBookAction(bookAddAction, model);
        if (commonAction != null){
            return commonAction;
        }
        try{
            ValidationUtils.invokeValidator(bookValidator, book, result);
            if (result.hasErrors()) {
                return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_UPDATE;
            }
            bookService.update(book);
            model.addAttribute(Attributes.VIEWED_BOOK_TYPE, book);
            return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_INFO;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/backToBookType", method = RequestMethod.GET)
    public String backToBookType(@ModelAttribute(value = Attributes.VIEWED_BOOK_TYPE_FLOW) Book book){
        if (book.getId() == null){
            return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_ADD;
        }else{
            return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_UPDATE;
        }
    }


}
