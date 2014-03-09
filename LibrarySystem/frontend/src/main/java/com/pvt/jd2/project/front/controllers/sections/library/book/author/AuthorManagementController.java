package com.pvt.jd2.project.front.controllers.sections.library.book.author;

import com.pvt.jd2.project.common.domain.Author;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.service.AuthorService;
import com.pvt.jd2.project.front.actions.Action;
import com.pvt.jd2.project.front.actions.ActionFactory;
import com.pvt.jd2.project.front.controllers.sections.library.book.types.ActionType;
import com.pvt.jd2.project.front.util.Attributes;
import com.pvt.jd2.project.front.util.NavigateOnPage;
import com.pvt.jd2.project.front.util.Parameters;
import com.pvt.jd2.project.front.util.TilesDefinitions;
import com.pvt.jd2.project.front.validators.AuthorValidator;
import com.pvt.jd2.project.front.validators.find.FindAuthorValidator;
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
public class AuthorManagementController {

    @Autowired
    private AuthorValidator authorValidator;

    @Autowired
    private FindAuthorValidator findAuthorFormBeanValidator;

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/addAuthor", method = RequestMethod.GET)
    public String addAuthor(@ModelAttribute(value = Attributes.VIEWED_AUTHOR) Author author) {
        return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_ADD;
    }

    @RequestMapping(value = "/addNewAuthor", method = RequestMethod.POST)
    public String addNewAuthor(@ModelAttribute(value = Attributes.VIEWED_AUTHOR) Author author,
                                  BindingResult result) {
        try{
            ValidationUtils.invokeValidator(authorValidator, author, result);
            if (result.hasErrors()){
                return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_ADD;
            }
            authorService.create(author);
            return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_INFO;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/listAuthors", method = RequestMethod.GET)
    public String listOfAuthors(HttpSession session,
                                Model model){
        List<Author> authors = authorService.list();
        Book viewedBookType = (Book)session.getAttribute(Attributes.VIEWED_BOOK_TYPE_FLOW);
        if ((viewedBookType != null) && (viewedBookType.getAuthors() != null)){
            authors.removeAll(viewedBookType.getAuthors());
        }
        model.addAttribute(Attributes.VIEWED_AUTHORS, authors);
        return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_LIST;
    }

    @RequestMapping(value = "/addAuthorToBookType", method = RequestMethod.POST)
    public String addToBookType(HttpSession session,
                                @RequestParam(value = Parameters.APPLY_AUTHOR_ID, required = false) String[] applyAuthorId,
                                @RequestParam(value = Parameters.DELETE_AUTHOR_ID, required = false) String[] deleteAuthorId,
                                @RequestParam(value = Parameters.INFO_AUTHOR_ID, required = false) String[] infoAuthorId,
                                @RequestParam(value = Parameters.ACTION) String authorAction,
                                Model model) {
        Action action = ActionFactory.getAuthorAction(authorAction, authorService);
        ActionType authorActionType = ActionFactory.getActionType(authorAction);
        switch(authorActionType){
            case APPLY_LIST:
                return action.perform(session, model, applyAuthorId);
            case APPLY:
                return action.perform(session, model, applyAuthorId);
            case DELETE:
                return action.perform(session, model, deleteAuthorId);
            default:
                return action.perform(session, model, infoAuthorId);
        }
    }

    @RequestMapping(value = "/deleteAuthor", method = RequestMethod.POST)
    public String deleteAuthor(@RequestParam(value = Parameters.AUTHOR_ID) String authorId,
                                  Model model){
        try{
            Author author = authorService.findById(Long.valueOf(authorId));
            authorService.delete(author);
            List<Author> authors = authorService.list();
            model.addAttribute(Attributes.VIEWED_AUTHORS, authors);
            return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_LIST;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/findAuthor", method = RequestMethod.GET)
    private String findAuthor(@ModelAttribute(value = Attributes.VIEWED_AUTHOR) Author formBean){
        return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_FIND;
    }

    @RequestMapping(value = "/foundAuthors", method = RequestMethod.POST)
    private String findAuthor(HttpSession session,
                              @ModelAttribute(value = Attributes.VIEWED_AUTHOR) Author formBean,
                              BindingResult result,
                              Model model) {
        try{
            ValidationUtils.invokeValidator(findAuthorFormBeanValidator, formBean, result);
            if (result.hasErrors()){
                return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_FIND;
            }
            return findAuthor(session, formBean, model);
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_ERROR;
        }
    }

    private String findAuthor(HttpSession session, Author formBean, Model model){
        List<Author> authors = authorService.listLike(formBean);
        Book viewedBookType = (Book)session.getAttribute(Attributes.VIEWED_BOOK_TYPE_FLOW);
        if ((viewedBookType != null) && (viewedBookType.getAuthors() != null)){
            authors.removeAll(viewedBookType.getAuthors());
        }
        model.addAttribute(Attributes.VIEWED_AUTHORS, authors);
        return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_LIST;
    }

    @RequestMapping(value = "/infoAuthor", method = RequestMethod.POST)
    public String infoAuthor(@RequestParam(value = Parameters.AUTHOR_ID) String authorId, Model model) {
        try{
            Author author = authorService.findById(Long.valueOf(authorId));
            model.addAttribute(Attributes.VIEWED_AUTHOR, author);
            return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_INFO;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/updateAuthor", method = RequestMethod.POST)
    public String updateAuthor(@RequestParam(value = Parameters.AUTHOR_ID) String authorId, Model model){
        try{
            Author author = authorService.findById(Long.valueOf(authorId));
            model.addAttribute(Attributes.VIEWED_AUTHOR, author);
            return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_UPDATE;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/changeAuthor", method = RequestMethod.POST)
    public String changeAuthor(HttpSession session, @ModelAttribute(value = Attributes.VIEWED_AUTHOR) Author author,
                                  BindingResult result) {
        try{
            ValidationUtils.invokeValidator(authorValidator, author, result);
            if (result.hasErrors()){
                return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_UPDATE;
            }
            Book viewedBookType = (Book)session.getAttribute(Attributes.VIEWED_BOOK_TYPE_FLOW);
            updateAuthorsOfViewedBookTypeFlow(viewedBookType, author);
            authorService.update(author);
            return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_INFO;
        }catch(BusinessLogicException e){
            e.printStackTrace(); //TODO kill me later
            return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_ERROR;
        }
    }

    private void updateAuthorsOfViewedBookTypeFlow(Book viewedBookType, Author author) {
        if (viewedBookType != null){
            List<Author> authors = viewedBookType.getAuthors();
            if (authors != null){
                if (authors.contains(author)){
                    authors.remove(author);
                    authors.add(author);
                }
            }
        }
    }

    @RequestMapping(value = "/removeSelectedAuthor", method = RequestMethod.POST)
    public String removeFromSelected(@ModelAttribute(value = Attributes.VIEWED_BOOK_TYPE_FLOW) Book viewedBookType,
                                     @ModelAttribute(value = Attributes.VIEWED_AUTHOR) Author formBean,
                                     @RequestParam(value = Parameters.INFO_AUTHOR_ID, required = false) String infoAuthorId,
                                     @RequestParam(value = Parameters.AUTHOR_ID) String authorId,
                                     @RequestParam(value = Parameters.ON_PAGE) String onPage,
                                     Model model) {
        try{
            List<Author> authors = viewedBookType.getAuthors();
            if (authors != null){
                Author tmpAuthor = authorService.findById(Long.valueOf(authorId));
                authors.remove(tmpAuthor);
            }
            if (infoAuthorId != null){
                Author author = authorService.findById(Long.valueOf(infoAuthorId));
                model.addAttribute(Attributes.VIEWED_AUTHOR, author);
            }
            return gotTo(onPage, model, viewedBookType);
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_ERROR;
        }
    }

    private String gotTo(String onPage, Model model, Book viewedBookType) {
        NavigateOnPage page = NavigateOnPage.valueOf(onPage);
        switch(page){
            case INFO:
                return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_INFO;
            case LIST:
                List<Author> authors = authorService.listWithout(viewedBookType.getAuthors());
                model.addAttribute(Attributes.VIEWED_AUTHORS, authors);
                return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_LIST;
            case ADD:
                return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_ADD;
            case FIND:
                return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_FIND;
            default:
                return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_ERROR;
        }
    }

}
