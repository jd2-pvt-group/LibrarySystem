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
<s:message code="pages.libraryManagement.listAuthors.actions.apply" var="apply"/>
<s:message code="pages.libraryManagement.listAuthors.actions.delete" var="delete"/>
<s:message code="pages.libraryManagement.listAuthors.actions.info" var="info"/>
<div class="data_content">
    <h3 class="well title"><s:message code="pages.libraryManagement.listAuthors.title"/></h3>
    <form action="${pageContext.request.contextPath}/management/addAuthorToBookType" method="POST">
        <input type="hidden" id="action" name="action"/>
        <input type="hidden" id="infoAuthor_id" name="infoAuthor_id">
        <table class="table">
            <c:choose>
                <c:when test="${not empty viewedAuthors}">
                    <thead>
                        <tr>
                            <th><s:message code="pages.libraryManagement.addAuthor.firstName"/></th>
                            <th><s:message code="pages.libraryManagement.addAuthor.lastName"/></th>
                            <th>${info}</th>
                            <c:if test="${not empty sessionScope['viewedBookTypeFlow']}">
                                <th>${apply}</th>
                            </c:if>
                            <th>${delete}</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="author" items="${viewedAuthors}">
                            <tr>
                                <td>${author.firstName}</td>
                                <td>${author.lastName}</td>
                                <td>
                                    <button class="btn btn-primary" type="submit"  onclick="beforeSubmitAndSetValue('#action','INFO','#infoGenre_id',${genre.id});">${info}</button>
                                </td>
                                <c:if test="${not empty sessionScope['viewedBookTypeFlow']}">
                                    <td>
                                        <input type="checkbox" class="checkbox" name="applyAuthor_id" value="${author.id}">
                                    </td>
                                </c:if>
                                <td>
                                    <input type="checkbox" class="checkbox" name="deleteAuthor_id" value="${author.id}">
                                </td>
                            </tr>
                        </c:forEach>
                        <c:if test="${not empty sessionScope['viewedBookTypeFlow']}">
                            <tr>
                                <td colspan="2">
                                    <button class="btn btn-primary" type="submit" onclick="beforeSubmit('#action','APPLY_LIST');">${apply}</button>
                                </td>
                            </tr>
                        </c:if>
                        <tr>
                            <td>
                                <button class="btn btn-primary" type="submit" onclick="beforeSubmit('#action','DELETE');">${delete}</button>
                            </td>
                        </tr>
                    </tbody>
                </c:when>
                <c:otherwise>
                    <s:message code="pages.libraryManagement.listAuthors.notFound"/>
                </c:otherwise>
            </c:choose>
        </table>
    </form>
    <jsp:include page="authorsSelected.jsp">
        <jsp:param name="onPage" value="LIST"/>
    </jsp:include>
</div>