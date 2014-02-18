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
    <h3 class="well title"><s:message code="pages.libraryManagement.infoPublisher.title" arguments="${viewedPublisher.name}"/></h3>
    <table class="table">
        <tbody>
            <tr>
                <td><s:message code="pages.libraryManagement.addPublisher.name"/>:</td>
                <td>${viewedPublisher.name}</td>
            </tr>
            <tr>
                <td><s:message code="pages.libraryManagement.addPublisher.address"/>:</td>
                <td>${viewedPublisher.address}</td>
            </tr>
        </tbody>
    </table>
    <table>
        <tr>
            <td>
                <form action="${pageContext.request.contextPath}/management/updatePublisher" method="POST">
                    <input type="hidden" name="publisher_id" value="${viewedPublisher.id}"/>
                    <s:message code="pages.libraryManagement.infoPublisher.actions.update" var="updatePublisher"/>
                    <button class="btn btn-primary" type="submit">${updatePublisher}</button>
                </form>
            </td>
            <c:if test="${not empty sessionScope['viewedBookTypeFlow']}">
                <td>
                    <form action="${pageContext.request.contextPath}/management/addPublisherToBookType" method="POST">
                        <input type="hidden" name="publisher_id" value="${viewedPublisher.id}"/>
                        <s:message code="pages.libraryManagement.addBookType.actions.addToBookType" var="addToBookType"/>
                        <button class="btn btn-primary" type="submit">${addToBookType}</button>
                    </form>
                </td>
            </c:if>
        </tr>
    </table>
    <jsp:include page="publisherSelected.jsp">
        <jsp:param name="publisher_id" value="${viewedPublisher.id}"/>
        <jsp:param name="onPage" value="INFO"/>
    </jsp:include>
</div>
