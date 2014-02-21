<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 06.02.14
  Time: 15:41
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<c:if test="${not empty sessionScope['viewedBookTypeFlow'] and not empty sessionScope['viewedBookTypeFlow'].publisher}">
    <div class="data_content">
        <hr/>
        <h3 class="well well-small title"><s:message code="pages.libraryManagement.infoPublisher.selectPublisher"/></h3>
        <table class="table">
            <tbody>
                <tr>
                    <td><s:message code="pages.libraryManagement.addPublisher.name"/>:</td>
                    <td>${sessionScope['viewedBookTypeFlow'].publisher.name}</td>
                </tr>
                <tr>
                    <td><s:message code="pages.libraryManagement.addPublisher.address"/>:</td>
                    <td>${sessionScope['viewedBookTypeFlow'].publisher.address}</td>
                </tr>
            </tbody>
        </table>
        <form action="${pageContext.request.contextPath}/management/removeSelectedPublisher" method="POST">
            <s:message code="pages.libraryManagement.listPublishers.actions.delete" var="delete"/>
            <c:if test="${not empty param['publisher_id']}">
                <input type="hidden" name="publisher_id" value="${param['publisher_id']}"/>
            </c:if>
            <input type="hidden" name="onPage" value="${param['onPage']}"/>
            <button class="btn btn-primary" type="submit">${delete}</button>
        </form>
    </div>
</c:if>
