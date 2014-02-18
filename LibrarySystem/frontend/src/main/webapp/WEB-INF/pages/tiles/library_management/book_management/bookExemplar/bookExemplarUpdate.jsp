<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 29.01.14
  Time: 1:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="data_content">
    <h3 class="well title"><s:message code="pages.libraryManagement.addBook.title"/></h3>
    <form:form action="${pageContext.request.contextPath}/management/changeBookExemplar" method="POST" commandName="viewedBookExemplar">
        <table class="table">
            <tbody>
                <tr>
                    <td><s:message code="pages.libraryManagement.bookType.isbn"/>:</td>
                    <td>
                        <c:choose>
                            <c:when test="${not empty viewedBookExemplar.book.isbn}">
                                <c:out value="${viewedBookExemplar.book.isbn}"/>
                            </c:when>
                            <c:otherwise>
                                <s:message code="pages.libraryManagement.addBook.noISBN"/>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr>
                    <td><s:message code="pages.libraryManagement.bookExemplar.libraryCode"/></td>
                    <td><form:input class="input-block-level" path="libraryCode"/></td>
                </tr>
                <tr>
                    <td colspan="2"><form:errors cssClass="alert alert-error" path="libraryCode"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.libraryManagement.bookType.name"/>:</td>
                    <td><c:out value="${viewedBookExemplar.book.name}"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.libraryManagement.bookType.description"/>:</td>
                    <td><c:out value="${viewedBookExemplar.book.description}"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.libraryManagement.bookType.bookSerial"/>:</td>
                    <td>
                        <c:choose>
                            <c:when test="${not empty viewedBookExemplar.book.bookSerial}">
                                <c:out value="${viewedBookExemplar.book.bookSerial.name}"/>
                            </c:when>
                            <c:otherwise>
                                <s:message code="pages.libraryManagement.addBook.noBookSerial"/>
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
                                <s:message code="pages.libraryManagement.addBook.noPublisher"/>
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
                <tr>
                    <td><s:message code="pages.libraryManagement.bookExemplar.isActive"/>:</td>
                    <td colspan="2"><form:checkbox cssClass="checkbox" path="active"/></td>
                </tr>
            </tbody>
        </table>
        <s:message code="pages.libraryManagement.bookExemplar.actions.update" var="updateBookExemplar"/>
        <button class="btn btn-primary" type="submit">${updateBookExemplar}</button>
    </form:form>
    <form action="${pageContext.request.contextPath}/management/infoBookExemplar" method="POST">
        <input type="hidden" name="bookExemplar_id" value="${sessionScope['viewedBookExemplarFlow'].id}"/>
        <s:message code="pages.libraryManagement.updateBookExemplar.actions.back" var="back"/>
        <button class="btn btn-primary" type="submit">${back}</button>
    </form>
</div>