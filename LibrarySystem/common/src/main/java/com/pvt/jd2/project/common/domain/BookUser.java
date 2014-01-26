package com.pvt.jd2.project.common.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 24.01.14
 * Time: 23:19
 */
@Entity
@Table(name="BOOK_USER")
public class BookUser implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="BOOK_ID")
    private Long bookId;

    @OneToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name="START_DATE")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name="END_DATE")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name="IS_CONTINUED")
    private boolean isContinued;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

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
