package com.pvt.jd2.project.front.controllers.sections.library.book.publisher;

import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.domain.Publisher;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.service.PublisherService;
import com.pvt.jd2.project.front.util.Attributes;
import com.pvt.jd2.project.front.util.NavigateOnPage;
import com.pvt.jd2.project.front.util.Parameters;
import com.pvt.jd2.project.front.util.TilesDefinitions;
import com.pvt.jd2.project.front.validators.find.FindPublisherValidator;
import com.pvt.jd2.project.front.validators.PublisherValidator;
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
 * Date: 04.02.14
 * Time: 10:54
 */
@Controller
@SessionAttributes(value = {
        Attributes.VIEWED_BOOK_TYPE_FLOW
})
@RequestMapping(value = "/management")
public class PublisherManagementController {

    @Autowired
    private PublisherValidator publisherValidator;

    @Autowired
    private FindPublisherValidator findPublisherFormBeanValidator;

    @Autowired
    private PublisherService publisherService;

    @RequestMapping(value = "/addPublisher", method = RequestMethod.GET)
    public String addPublisher(@ModelAttribute(value = Attributes.VIEWED_PUBLISHER) Publisher publisher) {
        return TilesDefinitions.LIBRARY_PUBLISHER_MANAGEMENT_ADD;
    }

    @RequestMapping(value = "/addNewPublisher", method = RequestMethod.POST)
    public String addNewPublisher(@ModelAttribute(value = Attributes.VIEWED_PUBLISHER) Publisher publisher,
                                   BindingResult result) {
        try{
            ValidationUtils.invokeValidator(publisherValidator, publisher, result);
            if (result.hasErrors()){
                return TilesDefinitions.LIBRARY_PUBLISHER_MANAGEMENT_ADD;
            }
            publisherService.create(publisher);
            return TilesDefinitions.LIBRARY_PUBLISHER_MANAGEMENT_INFO;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_PUBLISHER_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/listPublishers", method = RequestMethod.GET)
    public String listOfPublishers(Model model){
        List<Publisher> publishers = publisherService.list();
        model.addAttribute(Attributes.VIEWED_PUBLISHERS, publishers);
        return TilesDefinitions.LIBRARY_PUBLISHER_MANAGEMENT_LIST;
    }

    @RequestMapping(value = "/addPublisherToBookType", method = RequestMethod.POST)
    public String addToBookType(@ModelAttribute(value = Attributes.VIEWED_BOOK_TYPE_FLOW) Book viewedBookType,
                                @RequestParam(value = Parameters.PUBLISHER_ID) String publisherId) {
        Publisher publisher = publisherService.findById(Long.valueOf(publisherId));
        viewedBookType.setPublisher(publisher);
        if (viewedBookType.getId() == null){
            return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_ADD;
        }else{
            return TilesDefinitions.LIBRARY_BOOK_TYPE_MANAGEMENT_UPDATE;
        }
    }

    @RequestMapping(value = "/deletePublisher", method = RequestMethod.POST)
    public String deletePublisher(@RequestParam(value = Parameters.PUBLISHER_ID) String publisherId,
                                   Model model){
        try{
            Publisher publisher = publisherService.findById(Long.valueOf(publisherId));
            publisherService.delete(publisher);
            List<Publisher> publishers = publisherService.list();
            model.addAttribute(Attributes.VIEWED_PUBLISHERS, publishers);
            return TilesDefinitions.LIBRARY_PUBLISHER_MANAGEMENT_LIST;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_PUBLISHER_MANAGEMENT_ERROR;
        }
    }
    @RequestMapping(value = "/findPublisher", method = RequestMethod.GET)
    private String findPublisher(@ModelAttribute(value = Attributes.VIEWED_PUBLISHER) Publisher formBean){
        return TilesDefinitions.LIBRARY_PUBLISHER_MANAGEMENT_FIND;
    }

    @RequestMapping(value = "/foundPublishers", method = RequestMethod.POST)
    private String findPublisher(@ModelAttribute(value = Attributes.VIEWED_PUBLISHER) Publisher formBean,
                                  BindingResult result,
                                  Model model) {
        try{
            ValidationUtils.invokeValidator(findPublisherFormBeanValidator, formBean, result);
            if (result.hasErrors()){
                return TilesDefinitions.LIBRARY_PUBLISHER_MANAGEMENT_FIND;
            }
            return findPublisher(formBean, model);
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_PUBLISHER_MANAGEMENT_ERROR;
        }
    }

    private String findPublisher(Publisher formBean, Model model){
        List<Publisher> publishers = publisherService.listLike(formBean);
        model.addAttribute(Attributes.VIEWED_PUBLISHERS, publishers);
        return TilesDefinitions.LIBRARY_PUBLISHER_MANAGEMENT_LIST;
    }

    @RequestMapping(value = "/infoPublisher", method = RequestMethod.POST)
    public String infoPublisher(@RequestParam(value = Parameters.PUBLISHER_ID) String publisherId, Model model) {
        try{
            Publisher publisher = publisherService.findById(Long.valueOf(publisherId));
            model.addAttribute(Attributes.VIEWED_PUBLISHER, publisher);
            return TilesDefinitions.LIBRARY_PUBLISHER_MANAGEMENT_INFO;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_PUBLISHER_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/updatePublisher", method = RequestMethod.POST)
    public String updatePublisher(@RequestParam(value = Parameters.PUBLISHER_ID) String publisherId, Model model){
        try{
            Publisher publisher = publisherService.findById(Long.valueOf(publisherId));
            model.addAttribute(Attributes.VIEWED_PUBLISHER, publisher);
            return TilesDefinitions.LIBRARY_PUBLISHER_MANAGEMENT_UPDATE;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_PUBLISHER_MANAGEMENT_ERROR;
        }
    }

    @RequestMapping(value = "/changePublisher", method = RequestMethod.POST)
    public String changePublisher(HttpSession session, @ModelAttribute(value = Attributes.VIEWED_PUBLISHER) Publisher publisher,
                                   BindingResult result) {
        try{
            ValidationUtils.invokeValidator(publisherValidator, publisher, result);
            if (result.hasErrors()){
                return TilesDefinitions.LIBRARY_PUBLISHER_MANAGEMENT_UPDATE;
            }
            Book bookType = (Book)session.getAttribute(Attributes.VIEWED_BOOK_TYPE_FLOW);
            updatePublisherOfBookTypeFlow(bookType, publisher);
            publisherService.update(publisher);
            return TilesDefinitions.LIBRARY_PUBLISHER_MANAGEMENT_INFO;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_PUBLISHER_MANAGEMENT_ERROR;
        }
    }

    private void updatePublisherOfBookTypeFlow(Book bookType, Publisher publisher){
        if (bookType != null){
            Publisher selectedPublisher = bookType.getPublisher();
            if (selectedPublisher != null){
                bookType.setPublisher(publisher);
            }
        }
    }

    @RequestMapping(value = "/removeSelectedPublisher", method = RequestMethod.POST)
    public String removeSelectedPublisher(@ModelAttribute(value = Attributes.VIEWED_BOOK_TYPE_FLOW) Book viewedBookType,
                                          @ModelAttribute(value = Attributes.VIEWED_PUBLISHER) Publisher formBean,
                                          @RequestParam(value = Parameters.PUBLISHER_ID, required = false) String publisherId,
                                          @RequestParam(value = Parameters.ON_PAGE) String onPage,
                                          Model model){

        Publisher viewedPublisher = viewedBookType.getPublisher();
        if (viewedPublisher != null){
            viewedBookType.setPublisher(null);
        }
        try{
            if (publisherId != null){
                Publisher publisher = publisherService.findById(Long.valueOf(publisherId));
                model.addAttribute(Attributes.VIEWED_PUBLISHER, publisher);
            }
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_PUBLISHER_MANAGEMENT_ERROR;
        }
        return gotTo(onPage);
    }

    private String gotTo(String onPage) {
        NavigateOnPage page = NavigateOnPage.valueOf(onPage);
        switch(page){
            case INFO:
                return TilesDefinitions.LIBRARY_PUBLISHER_MANAGEMENT_INFO;
            case LIST:
                return TilesDefinitions.LIBRARY_PUBLISHER_MANAGEMENT_LIST;
            case ADD:
                return TilesDefinitions.LIBRARY_PUBLISHER_MANAGEMENT_ADD;
            case FIND:
                return TilesDefinitions.LIBRARY_PUBLISHER_MANAGEMENT_FIND;
            default:
                return TilesDefinitions.LIBRARY_PUBLISHER_MANAGEMENT_ERROR;
        }
    }

}
