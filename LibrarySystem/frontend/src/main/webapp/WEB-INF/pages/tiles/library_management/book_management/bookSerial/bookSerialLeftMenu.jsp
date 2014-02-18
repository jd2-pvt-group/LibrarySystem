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
    <a href="${pageContext.request.contextPath}/management/addBookSerial">
        <i class="icon-chevron-right"></i> <s:message code="pages.libraryManagement.addBookSerial"/>
    </a>
</li>
<li>
    <a href="${pageContext.request.contextPath}/management/listBookSerials">
        <i class="icon-chevron-right"></i> <s:message code="pages.libraryManagement.listBookSerials"/>
    </a>
</li>
<li>
    <a href="${pageContext.request.contextPath}/management/findBookSerial">
        <i class="icon-chevron-right"></i> <s:message code="pages.libraryManagement.findBookSerial"/>
    </a>
</li>
<c:choose>
    <c:when test="${not empty sessionScope['viewedBookTypeFlow']}">
        <li><hr/></li>
        <li>
            <a href="${pageContext.request.contextPath}/management/addBookType">
                <i class="icon-chevron-left"></i> <s:message code="pages.libraryManagement.addBookType.actions.back"/>
            </a>
        </li>
    </c:when>
    <c:otherwise>
        <li><hr/></li>
        <li>
            <a href="${pageContext.request.contextPath}/management/bookManagement">
                <i class="icon-chevron-left"></i> <s:message code="pages.libraryManagement.bookManagement.back"/>
            </a>
        </li>
    </c:otherwise>
</c:choose>