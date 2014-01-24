package com.pvt.jd2.project.common.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 24.01.14
 * Time: 23:19
 */
public class BookUser implements Serializable {

    private Book book;

    private User user;

    private Date startDate;

    private Date endDate;

    private boolean isContinued;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isContinued() {
        return isContinued;
    }

    public void setContinued(boolean continued) {
        isContinued = continued;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookUser bookUser = (BookUser) o;

        if (book != null ? !book.equals(bookUser.book) : bookUser.book != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return book != null ? book.hashCode() : 0;
    }
}
