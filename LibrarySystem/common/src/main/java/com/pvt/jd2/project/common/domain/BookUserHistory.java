package com.pvt.jd2.project.common.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 24.01.14
 * Time: 23:30
 */
@Entity
@Table(name="BOOK_USER_HISTORY")
public class BookUserHistory implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    @OneToOne
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

    @Column(name="IS_IN_TIME")
    private boolean isInTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isInTime() {
        return isInTime;
    }

    public void setInTime(boolean inTime) {
        isInTime = inTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookUserHistory that = (BookUserHistory) o;

        if (book != null ? !book.equals(that.book) : that.book != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return book != null ? book.hashCode() : 0;
    }
}
