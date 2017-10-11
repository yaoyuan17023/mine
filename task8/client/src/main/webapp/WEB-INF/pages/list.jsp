<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 姚远
  Date: 2017/10/10
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${studentList}" var="studentList" begin="0" end="3">
    <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
        <div>
                <%--<img src="${pageContext.request.contextPath}/t10/imges/242424.png">--%>
            <img src="${studentList.picture}">
            <span>${studentList.job}：${studentList.name}</span>
            <p class="text-left">${studentList.profession}:${studentList.introduce}</p>
        </div>
    </li>
</c:forEach>
</body>
</html>
