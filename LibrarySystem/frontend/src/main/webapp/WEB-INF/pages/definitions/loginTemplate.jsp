<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 28.01.14
  Time: 0:08
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title><s:message code="pages.login.title"/></title>
</head>
<body>
    <table>
        <tr><td colspan="3"/></tr>
        <tr><td></td>
            <td><tiles:insertAttribute name="login_form"/></td>
            <td></td>
        </tr>
        <tr><td colspan="3"/></tr>
    </table>
</body>
</html>