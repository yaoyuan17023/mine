

<%--
  Created by IntelliJ IDEA.
  User: 姚远
  Date: 2017/9/6
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
</head>
<body>
<table>
    <tr>
        <td colspan="2">
            <tiles:insertAttribute name="header" />
        </td>
    </tr>
    <tr>
        <td>
            <tiles:insertAttribute name="menu" />
        </td>
        <td>
            <tiles:insertAttribute name="body" />
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <tiles:insertAttribute name="footer" ignore="true" />
        </td>
    </tr>
</table>
</body>
</html>
