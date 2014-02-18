<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 29.01.14
  Time: 1:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<li>
    <a href="${pageContext.request.contextPath}/management/listAssigned">
        <i class="icon-chevron-right"></i> <s:message code="pages.libraryManagement.listAssigned"/>
    </a>
</li>
<li>
    <a href="${pageContext.request.contextPath}/management/findAssigned">
        <i class="icon-chevron-right"></i> <s:message code="pages.libraryManagement.findAssigned"/>
    </a>
</li>
<li><hr/></li>
<li>
    <a href="${pageContext.request.contextPath}/management/libraryManagement">
        <i class="icon-chevron-left"></i> <s:message code="pages.libraryManagement.backToLibraryManagement"/>
    </a>
</li>