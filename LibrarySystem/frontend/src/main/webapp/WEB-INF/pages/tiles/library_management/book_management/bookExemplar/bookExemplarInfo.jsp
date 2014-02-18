<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 29.01.14
  Time: 1:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<s:message code="pages.libraryManagement.addBook.noBookSerial" var="noBookSerial"/>
<s:message code="pages.libraryManagement.addBook.noPublisher" var="noPublisher"/>
<div class="data_content">
    <h3 class="well title">
        <s:message code="pages.libraryManagement.infoBookExemplar.title" arguments="${viewedBookExemplar.book.isbn},${viewedBookExemplar.libraryCode},${viewedBookExemplarFormBean.book.name}"/>
    </h3>
    <table class="table">
        <tbody>
            <tr>
                <td><s:message code="pages.libraryManagement.bookType.isbn"/>:</td>
                <td>${viewedBookExemplar.book.isbn}</td>
            </tr>
            <tr>
                <td><s:message code="pages.libraryManagement.bookExemplar.libraryCode"/>:</td>
                <td>${viewedBookExemplar.libraryCode}</td>
            </tr>
            <tr>
                <td><s:message code="pages.libraryManagement.bookExemplar.isActive"/>:</td>
                <td>${viewedBookExemplar.active}</td>
            </tr>
            <tr>
                <td><s:message code="pages.libraryManagement.bookType.name"/>:</td>
                <td>${viewedBookExemplar.book.name}</td>
            </tr>
            <tr>
                <td><s:message code="pages.libraryManagement.bookType.description"/>:</td>
                <td>${viewedBookExemplar.book.description}</td>
            </tr>
            <tr>
                <td><s:message code="pages.libraryManagement.bookType.bookSerial"/>:</td>
                <td>
                    <c:choose>
                        <c:when test="${not empty viewedBookExemplar.book.bookSerial}">
                            <c:out value="${viewedBookExemplar.book.bookSerial.name}"/>
                        </c:when>
                        <c:otherwise>
                            <c:out value="${noBookSerial}"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td><s:message code="pages.libraryManagement.bookType.publisher"/>:</td>
                <td>
                    <c:choose>
                        <c:when test="${not empty viewedBookExemplar.book.publisher}">
                            <c:out value="${viewedBookExemplar.book.publisher.name}"/>
                        </c:when>
                        <c:otherwise>
                            <c:out value="${noPublisher}"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td><s:message code="pages.libraryManagement.bookType.authors"/>:</td>
                <td>
                    <c:choose>
                        <c:when test="${not empty viewedBookExemplar.book.authors}">
                            <c:forEach var="author" items="${viewedBookExemplar.book.authors}">
                                <c:out value="${author.firstName} ${author.lastName}"/><br/>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <s:message code="pages.libraryManagement.addBook.noAuthors"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td><s:message code="pages.libraryManagement.bookType.genres"/>:</td>
                <td>
                    <c:choose>
                        <c:when test="${not empty viewedBookExemplar.book.genres}">
                            <c:forEach var="genre" items="${viewedBookExemplar.book.genres}">
                                <c:out value="${genre.name}"/><br/>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <s:message code="pages.libraryManagement.addBook.noGenres"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </tbody>
    </table>
    <form action="${pageContext.request.contextPath}/management/updateBookExemplar" method="POST">
        <input type="hidden" name="bookExemplar_id" value="${viewedBookExemplar.id}"/>
        <s:message code="pages.libraryManagement.bookExemplar.actions.update" var="updateBookExemplar"/>
        <button class="btn btn-primary" type="submit">${updateBookExemplar}</button>
    </form>
</div>