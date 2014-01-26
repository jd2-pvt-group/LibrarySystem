package com.pvt.jd2.project.common.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 26.01.14
 * Time: 20:19
 */
@Entity
@Table(name="BOOK_EXEMPLAR")
public class BookExemplar implements Serializable {

    @EmbeddedId
    @AttributeOverrides(value = {
    @AttributeOverride(name="bookId", column = @Column(name="BOOK_ID")),
    @AttributeOverride(name="libraryCode", column = @Column(name="LIBRARY_CODE"))})
    private BookExemplarId id;

    @Column(name="IS_ACTIVE")
    private boolean isActive;

    public BookExemplarId getId() {
        return id;
    }

    public void setId(BookExemplarId id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookExemplar that = (BookExemplar) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
