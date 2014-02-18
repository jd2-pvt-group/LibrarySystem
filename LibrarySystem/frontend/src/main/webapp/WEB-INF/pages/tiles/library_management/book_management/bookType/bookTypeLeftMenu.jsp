<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 29.01.14
  Time: 1:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<li>
    <a href="${pageContext.request.contextPath}/management/addBookType">
        <s:message code="pages.libraryManagement.addBookType"/>
    </a>
</li>
<li>
    <a href="${pageContext.request.contextPath}/management/listBookTypes">
        <s:message code="pages.libraryManagement.listBookTypes"/>
    </a>
</li>
<li>
    <a href="${pageContext.request.contextPath}/management/findBookType">
        <s:message code="pages.libraryManagement.findBookType"/>
    </a>
</li>
<c:choose>
    <c:when test="${not empty sessionScope['viewedBookExemplarFlow']}">
        <li><hr/></li>
        <li>
            <a href="${pageContext.request.contextPath}/management/addBookExemplar">
                <s:message code="pages.libraryManagement.addBook.back"/>
            </a>
        </li>
    </c:when>
    <c:otherwise>
        <li><hr/></li>
        <li>
            <a href="${pageContext.request.contextPath}/management/bookManagement">
                <s:message code="pages.libraryManagement.bookManagement.back"/>
            </a>
        </li>
    </c:otherwise>
</c:choose>