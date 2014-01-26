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
@Table(name="BOOK_EXEMPLAR_USER_HISTORY")
public class BookExemplarUserHistory implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long id;

    @OneToOne
    @JoinColumns(value = {
        @JoinColumn(name = "BOOK_ID"),
        @JoinColumn(name = "LIBRARY_CODE")})
    private BookExemplar bookExemplar;

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

    public BookExemplar getBookExemplar() {
        return bookExemplar;
    }

    public void setBookExemplar(BookExemplar bookExemplar) {
        this.bookExemplar = bookExemplar;
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

        BookExemplarUserHistory that = (BookExemplarUserHistory) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
