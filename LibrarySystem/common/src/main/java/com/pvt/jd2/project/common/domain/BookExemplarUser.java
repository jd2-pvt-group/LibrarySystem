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
@Table(name="BOOK_EXEMPLAR_USER")
public class BookExemplarUser implements Serializable {

    @EmbeddedId
    @AttributeOverrides(value = {
            @AttributeOverride(name="bookId", column = @Column(name="BOOK_ID")),
            @AttributeOverride(name="libraryCode", column = @Column(name="LIBRARY_CODE"))})
    private BookExemplarId id;

    @OneToOne
    @JoinColumns(value = {
    @JoinColumn(name = "BOOK_ID"),
    @JoinColumn(name = "LIBRARY_CODE")})
    private BookExemplar bookExemplar;

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

    public BookExemplarId getId() {
        return id;
    }

    public void setId(BookExemplarId id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookExemplarUser that = (BookExemplarUser) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
