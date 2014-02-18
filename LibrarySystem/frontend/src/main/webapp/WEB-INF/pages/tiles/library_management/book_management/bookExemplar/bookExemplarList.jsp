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
<s:message code="pages.libraryManagement.listBookExemplar.actions.info" var="info"/>
<s:message code="pages.libraryManagement.listBookExemplar.actions.delete" var="delete"/>
<div class="data_content">
    <h3 class="well title"><s:message code="pages.libraryManagement.listBookExemplar.title"/></h3>
    <table class="table">
        <c:choose>
            <c:when test="${not empty viewedBookExemplars}">
                <thead>
                    <tr>
                        <th><s:message code="pages.libraryManagement.bookType.isbn"/></th>
                        <th><s:message code="pages.libraryManagement.bookExemplar.libraryCode"/></th>
                        <th><s:message code="pages.libraryManagement.bookType.name"/></th>
                        <th><s:message code="pages.libraryManagement.bookExemplar.isActive"/></th>
                        <th>${info}</th>
                        <th>${delete}</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="bookExemplar" items="${viewedBookExemplars}">
                        <tr>
                            <td>${bookExemplar.book.isbn}</td>
                            <td>${bookExemplar.libraryCode}</td>
                            <td>${bookExemplar.book.name}</td>
                            <td>${bookExemplar.active}</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/management/infoBookExemplar" method="POST">
                                    <input type="hidden" name="bookExemplar_id" value="${bookExemplar.id}"/>
                                    <button class="btn btn-primary" type="submit">${info}</button>
                                </form>
                            </td>
                            <td>
                                <form action="${pageContext.request.contextPath}/management/deleteBookExemplar" method="POST">
                                    <input type="hidden" name="bookExemplar_id" value="${bookExemplar.id}"/>
                                    <button class="btn btn-primary" type="submit">${delete}</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </c:when>
            <c:otherwise>
                <s:message code="pages.libraryManagement.listBookExemplar.notFound"/>
            </c:otherwise>
        </c:choose>
    </table>
</div>