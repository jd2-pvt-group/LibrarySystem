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
<div class="data_content">
    <h3 class="well title"><s:message code="pages.libraryManagement.infoGenre.title" arguments="${viewedGenre.name}"/></h3>
    <table class="table">
        <tbody>
            <tr>
                <td><s:message code="pages.libraryManagement.infoGenre.name"/>:</td>
                <td>${viewedGenre.name}</td>
            </tr>
            <tr>
                <td><s:message code="pages.libraryManagement.infoGenre.description"/>:</td>
                <td>${viewedGenre.description}</td>
            </tr>
        </tbody>
    </table>
    <table>
        <tr>
            <td>
                <form action="${pageContext.request.contextPath}/management/updateGenre" method="POST">
                    <input type="hidden" name="genre_id" value="${viewedGenre.id}"/>
                    <s:message code="pages.libraryManagement.infoGenre.actions.update" var="updateGenre"/>
                    <button class="btn btn-primary" type="submit">${updateGenre}</button>
                </form>
            </td>
            <c:if test="${not empty sessionScope['viewedBookTypeFlow']}">
                <td>
                    <form action="${pageContext.request.contextPath}/management/addGenreToBookType" method="POST">
                        <input type="hidden" id="action" name="action" value="APPLY"/>
                        <input type="hidden" name="applyGenre_id" value="${viewedGenre.id}"/>
                        <s:message code="pages.libraryManagement.infoGenre.actions.addToBookType" var="addToBookType"/>
                        <button class="btn btn-primary" type="submit">${addToBookType}</button>
                    </form>
                </td>
            </c:if>
        </tr>
    </table>
    <jsp:include page="genresSelected.jsp">
        <jsp:param name="onPage" value="INFO"/>
        <jsp:param name="infoGenre_id" value="${viewedGenre.id}"/>
    </jsp:include>
</div>