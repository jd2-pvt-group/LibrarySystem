<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 06.02.14
  Time: 15:41
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<s:message code="pages.libraryManagement.listAuthors.actions.delete" var="delete"/>
<c:if test="${not empty sessionScope['viewedBookTypeFlow'] and not empty sessionScope['viewedBookTypeFlow'].authors}">
    <div class="data_content">
        <hr/>
        <h3 class="well title"><s:message code="pages.libraryManagement.infoAuthor.selectAuthors"/></h3>
        <table class="table">
            <thead>
                <tr>
                    <th><s:message code="pages.libraryManagement.infoAuthor.firstName"/></th>
                    <th><s:message code="pages.libraryManagement.infoAuthor.lastName"/></th>
                    <th>${delete}</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="author" items="${sessionScope['viewedBookTypeFlow'].authors}">
                    <tr>
                        <td>${author.firstName}</td>
                        <td>${author.lastName}</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/management/removeSelectedAuthor" method="POST">
                                <c:if test="${not empty param['infoAuthor_id']}">
                                    <input type="hidden" name="infoAuthor_id" value="${param['infoAuthor_id']}"/>
                                </c:if>
                                <input type="hidden" name="author_id" value="${author.id}"/>
                                <input type="hidden" name="onPage" value="${param['onPage']}"/>
                                <button class="btn btn-primary" type="submit">${delete}</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</c:if>
