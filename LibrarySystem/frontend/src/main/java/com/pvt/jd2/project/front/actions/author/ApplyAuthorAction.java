package com.pvt.jd2.project.front.actions.author;

import com.pvt.jd2.project.common.domain.Author;
import com.pvt.jd2.project.common.domain.Book;
import com.pvt.jd2.project.common.exceptions.BusinessLogicException;
import com.pvt.jd2.project.common.service.AuthorService;
import com.pvt.jd2.project.front.util.Attributes;
import com.pvt.jd2.project.front.util.TilesDefinitions;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 09.02.14
 * Time: 12:01
 */
public class ApplyAuthorAction extends AbstractAuthorAction {

    public ApplyAuthorAction(AuthorService authorService) {
        super(authorService);
    }

    @Override
    public String perform(HttpSession session, Model model, String[] authorIds) {
        try{
            Book viewedBookType = (Book)session.getAttribute(Attributes.VIEWED_BOOK_TYPE_FLOW);
            Author author = authorService.findById(Long.valueOf(authorIds[0]));
            if (viewedBookType != null){
                List<Author> authors = getAuthorsFrom(viewedBookType);
                if (!authors.contains(author)){
                    authors.add(author);
                }
            }
            model.addAttribute(Attributes.VIEWED_AUTHOR, author);
            return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_INFO;
        }catch(BusinessLogicException e){
            return TilesDefinitions.LIBRARY_AUTHOR_MANAGEMENT_ERROR;
        }
    }
}
