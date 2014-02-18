<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 29.01.14
  Time: 1:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<li>
    <a href="${pageContext.request.contextPath}/management/listHistory">
        <i class="icon-chevron-right"></i> <s:message code="pages.libraryManagement.listHistory"/>
    </a>
</li>
<li>
    <a href="${pageContext.request.contextPath}/management/findHistory">
        <i class="icon-chevron-right"></i> <s:message code="pages.libraryManagement.findHistory"/>
    </a>
</li>
<li><hr/></li>
<li>
    <a href="${pageContext.request.contextPath}/management/libraryManagement">
        <i class="icon-chevron-left"></i> <s:message code="pages.libraryManagement.backToLibraryManagement"/>
    </a>
</li>