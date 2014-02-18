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
    <h3 class="well title"><s:message code="pages.libraryManagement.infoAuthor.title" arguments="${viewedAuthor.firstName}, ${viewedAuthor.lastName}"/></h3>
    <table class="table">
        <tbody>
            <tr>
                <td><s:message code="pages.libraryManagement.infoAuthor.firstName"/>:</td>
                <td>${viewedAuthor.firstName}</td>
            </tr>
            <tr>
                <td><s:message code="pages.libraryManagement.infoAuthor.lastName"/>:</td>
                <td>${viewedAuthor.lastName}</td>
            </tr>
        </tbody>
    </table>
    <table>
        <tr>
            <td>
                <form action="${pageContext.request.contextPath}/management/updateAuthor" method="POST">
                    <input type="hidden" name="author_id" value="${viewedAuthor.id}"/>
                    <s:message code="pages.libraryManagement.infoAuthor.actions.update" var="updateAuthor"/>
                    <button class="btn btn-primary" type="submit">${updateAuthor}</button>
                </form>
            </td>
            <c:if test="${not empty sessionScope['viewedBookTypeFlow']}">
                <td>
                    <form action="${pageContext.request.contextPath}/management/addAuthorToBookType" method="POST">
                        <input type="hidden" id="action" name="action" value="APPLY"/>
                        <input type="hidden" name="applyAuthor_id" value="${viewedAuthor.id}"/>
                        <s:message code="pages.libraryManagement.infoAuthor.actions.addToBookType" var="addToBookType"/>
                        <button class="btn btn-primary" type="submit">${addToBookType}</button>
                    </form>
                </td>
            </c:if>
        </tr>
    </table>
    <jsp:include page="authorsSelected.jsp">
        <jsp:param name="onPage" value="INFO"/>
        <jsp:param name="infoAuthor_id" value="${viewedAuthor.id}"/>
    </jsp:include>
</div>