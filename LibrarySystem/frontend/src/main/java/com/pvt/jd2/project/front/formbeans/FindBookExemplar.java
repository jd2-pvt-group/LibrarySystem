package com.pvt.jd2.project.front.formbeans;

import com.pvt.jd2.project.common.domain.ActivationStatus;
import com.pvt.jd2.project.common.domain.BookExemplar;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 14.02.14
 * Time: 20:53
 */
public class FindBookExemplar implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String BOOK_EXEMPLAR_BOOK_ISBN = "bookExemplar.book.isbn";

    private BookExemplar bookExemplar;
    private ActivationStatus status;

    public FindBookExemplar(){
        bookExemplar = new BookExemplar();
        status = ActivationStatus.NONE;
    }

    public BookExemplar getBookExemplar() {
        return bookExemplar;
    }

    public void setBookExemplar(BookExemplar bookExemplar) {
        this.bookExemplar = bookExemplar;
    }

    public ActivationStatus getStatus() {
        return status;
    }

    public void setStatus(ActivationStatus status) {
        this.status = status;
    }
}
