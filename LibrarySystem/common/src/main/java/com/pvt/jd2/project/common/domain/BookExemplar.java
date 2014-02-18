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

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    @Column(name = "LIBRARY_CODE")
    private String libraryCode;

    @Column(name="IS_ACTIVE")
    private boolean isActive;

    public BookExemplar(){
        book = new Book();
    }

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

    public String getLibraryCode() {
        return libraryCode;
    }

    public void setLibraryCode(String libraryCode) {
        this.libraryCode = libraryCode;
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

        if (book != null ? !book.equals(that.book) : that.book != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (libraryCode != null ? !libraryCode.equals(that.libraryCode) : that.libraryCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (book != null ? book.hashCode() : 0);
        result = 31 * result + (libraryCode != null ? libraryCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BookExemplar{" +
                "id=" + id +
                ", libraryCode='" + libraryCode + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
