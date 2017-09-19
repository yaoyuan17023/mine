<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 姚远
  Date: 2017/9/18
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${users != null}">
<table border="1" cellpadding="10" cellspacing="0">
    <tr>
        <th>id</th>
        <th>user</th>
        <th>password</th>
    </tr>
<c:forEach items="${users}" var="users">
    <tr>
        <td>${users.id}</td>
        <td>${users.user}</td>
        <td>${users.password}</td>
    </tr>
</c:forEach>
</table>
    </c:if>

</body>
</html>
