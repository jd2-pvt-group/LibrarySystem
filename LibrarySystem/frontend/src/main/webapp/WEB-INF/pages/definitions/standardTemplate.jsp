<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 29.01.14
  Time: 1:14
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <title><s:message code="pages.standard.title"/></title>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-2.0.3.js"></script>

        <!-- bookExemplar, book, publisher, author, genre types -->
        <script lang="text/javascript">

            function beforeSubmit(action, actionName){
                $(action).val(actionName);
                return false;
            }

            function beforeSubmitAndSetValue(action, actionName, id, value){
                $(id).val(value);
                return beforeSubmit(action, actionName);
            }

        </script>
    </head>
    <body>
        <table>
            <tr>
                <td colspan="2"><tiles:insertAttribute name="header"/></td>
            </tr>
            <tr>
                <td colspan="2"><tiles:insertAttribute name="top_menu"/></td>
            </tr>
            <tr>
                <td><tiles:insertAttribute name="left_menu"/></td>
                <td><tiles:insertAttribute name="content"/></td>
            </tr>
            <tr>
                <td colspan="2"><tiles:insertAttribute name="footer"/></td>
            </tr>
        </table>
    </body>
</html>