package com.pvt.jd2.project.common.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 26.01.14
 * Time: 21:09
 */
@Embeddable
public class BookExemplarId implements Serializable {

    private Long bookId;
    private Long libraryCode;

    public Long getLibraryCode() {
        return libraryCode;
    }

    public void setLibraryCode(Long libraryCode) {
        this.libraryCode = libraryCode;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookExemplarId that = (BookExemplarId) o;

        if (bookId != null ? !bookId.equals(that.bookId) : that.bookId != null) return false;
        if (libraryCode != null ? !libraryCode.equals(that.libraryCode) : that.libraryCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookId != null ? bookId.hashCode() : 0;
        result = 31 * result + (libraryCode != null ? libraryCode.hashCode() : 0);
        return result;
    }
}
