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
<s:message code="pages.libraryManagement.addBook.noBookName" var="noBookName"/>
<s:message code="pages.libraryManagement.addBook.noBookDescription" var="noBookDescription"/>
<s:message code="pages.libraryManagement.addBook.noBookSerial" var="noBookSerial"/>
<s:message code="pages.libraryManagement.addBook.noPublisher" var="noPublisher"/>
<s:message code="pages.libraryManagement.addBook.addBookSerial" var="selectBookSerial"/>
<s:message code="pages.libraryManagement.addBook.addPublisher" var="selectPublisher"/>
<s:message code="pages.libraryManagement.addBook.addAuthors" var="selectAuthors"/>
<s:message code="pages.libraryManagement.addBook.addGenres" var="selectGenres"/>
<div class="data_content">
    <h3 class="well title"><s:message code="pages.libraryManagement.addBookType.title"/></h3>
    <form:form action="${pageContext.request.contextPath}/management/changeBookType" method="POST" commandName="viewedBookTypeFlow">
        <input type="hidden" id="actionId" name="bookAddAction"/>
        <table class="table">
            <tbody>
                <tr>
                    <td><s:message code="pages.libraryManagement.bookType.isbn"/>:</td>
                    <td colspan="2">
                        <form:input cssClass="input-block-level" path="isbn"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="3"><form:errors cssClass="alert alert-error" path="isbn"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.libraryManagement.bookType.name"/>:</td>
                    <td colspan="2">
                        <form:input cssClass="input-block-level" path="name"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="3"><form:errors cssClass="alert alert-error" path="name"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.libraryManagement.bookType.description"/>:</td>
                    <td colspan="2">
                        <form:textarea rows="5" cssClass="input-block-level" path="description"/>
                    </td>
                </tr>
                <tr>
                    <td><s:message code="pages.libraryManagement.bookType.bookSerial"/>:</td>
                    <td>
                        <c:choose>
                            <c:when test="${not empty viewedBookTypeFlow.bookSerial}">
                                <c:out value="${viewedBookTypeFlow.bookSerial.name}"/>
                            </c:when>
                            <c:otherwise>
                                <c:out value="${noBookSerial}"/>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <button class="btn btn-primary" type="submit" onclick="beforeSubmit('#actionId','SELECT_BOOK_SERIAL');">${selectBookSerial}</button>
                    </td>
                </tr>
                <tr>
                    <td><s:message code="pages.libraryManagement.bookType.publisher"/>:</td>
                    <td>
                        <c:choose>
                            <c:when test="${not empty viewedBookTypeFlow.publisher}">
                                <c:out value="${viewedBookTypeFlow.publisher.name}"/>
                            </c:when>
                            <c:otherwise>
                                <c:out value="${noPublisher}"/>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <button class="btn btn-primary" type="submit" onclick="beforeSubmit('#actionId','SELECT_PUBLISHER');">${selectPublisher}</button>
                    </td>
                </tr>
                <tr>
                    <td colspan="3"><form:errors cssClass="alert alert-error" path="publisher"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.libraryManagement.bookType.authors"/>:</td>
                    <td>
                        <c:choose>
                            <c:when test="${not empty viewedBookTypeFlow.authors}">
                                <c:forEach var="author" items="${viewedBookTypeFlow.authors}">
                                    <c:out value="${author.firstName} ${author.lastName}"/><br/>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <s:message code="pages.libraryManagement.addBook.noAuthors"/>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <button class="btn btn-primary" type="submit" onclick="beforeSubmit('#actionId','SELECT_AUTHORS');">${selectAuthors}</button>
                    </td>
                </tr>
                <tr>
                    <td colspan="3"><form:errors cssClass="alert alert-error" path="authors"/></td>
                </tr>
                <tr>
                    <td><s:message code="pages.libraryManagement.bookType.genres"/>:</td>
                    <td>
                        <c:choose>
                            <c:when test="${not empty viewedBookTypeFlow.genres}">
                                <c:forEach var="genre" items="${viewedBookTypeFlow.genres}">
                                    <c:out value="${genre.name}"/><br/>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <s:message code="pages.libraryManagement.addBook.noGenres"/>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <button class="btn btn-primary" type="submit" onclick="beforeSubmit('#actionId','SELECT_GENRES');">${selectGenres}</button>
                    </td>
                </tr>
                <tr>
                    <td colspan="3"><form:errors cssClass="alert alert-error" path="genres"/></td>
                </tr>
            </tbody>
        </table>
        <s:message code="pages.libraryManagement.addBookType.actions.update" var="update"/>
        <button class="btn btn-primary" type="submit">${update}</button>
    </form:form>
    <form action="${pageContext.request.contextPath}/management/infoBookType" method="POST">
        <input type="hidden" name="bookType_id" value="${viewedBookTypeFlow.id}"/>
        <s:message code="pages.libraryManagement.addBookType.actions.back" var="backToInfo"/>
        <button class="btn btn-primary" type="submit">${backToInfo}</button>
    </form>
</div>