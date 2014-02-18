<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 29.01.14
  Time: 1:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<li>
    <a href="${pageContext.request.contextPath}/management/bookManagement">
        <i class="icon-chevron-right"></i> <s:message code="pages.libraryManagement.bookManagement"/>
    </a>
</li>
<li>
    <a href="${pageContext.request.contextPath}/management/bookOrderingManagement">
        <i class="icon-chevron-right"></i> <s:message code="pages.libraryManagement.bookOrderingManagement"/>
    </a>
</li>
<li>
    <a href="${pageContext.request.contextPath}/management/bookHistoryManagement">
        <i class="icon-chevron-right"></i> <s:message code="pages.libraryManagement.bookHistoryManagement"/>
    </a>
</li>
