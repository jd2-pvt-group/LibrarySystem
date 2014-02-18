package com.pvt.jd2.project.front.actions.author;

import com.pvt.jd2.project.common.domain.Author;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.service.AuthorService;
import com.pvt.jd2.project.front.util.Attributes;
import com.pvt.jd2.project.front.util.TilesDefinitions;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 08.02.14
 * Time: 13:10
 */
public class InfoAuthorAction extends AbstractAuthorAction {

    public InfoAuthorAction(AuthorService authorService) {
        super(authorService);
    }

    @Override
    public String perform(HttpSession session, Model model, String[] authorIds) {
        try{
            Author tmpAuthor = authorService.findById(Long.valueOf(authorIds[0]));
            model.addAttribute(Attributes.VIEWED_AUTHOR, tmpAuthor);
            return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_INFO;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_ERROR;
        }
    }

}

