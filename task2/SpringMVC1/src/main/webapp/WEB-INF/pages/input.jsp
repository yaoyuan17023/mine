<%--
  Created by IntelliJ IDEA.
  User: 姚远
  Date: 2017/8/22
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Title</title>
</head>
<body>
<h2>新增学生信息</h2>
<hr>
    <%--可以更快速的开发出表单页面，而且可以更方便的进行表单值的回显--%>

    <form:form action="${pageContext.request.contextPath}/a/student/insert" method="post" modelAttribute="student">
        name:<form:input path="name"/>
        <br>
        qq:<form:input path="qq"/>
        <br>
        type:<form:input path="type"/>
        <br>
        time:<form:input path="time"/>
        <br>
        school:<form:input path="school"/>
        <br>
        number:<form:input path="number"/>
        <br>
        link:<form:input path="link"/>
        <br>
        hope:<form:input path="hope"/>
        <br>
        referrer:<form:input path="referrer"/>
        <br>
        from_where:<form:input path="from_where"/>
        <br>
        id:<form:input path="id"/>
        <br>
        create_at:<form:input path="create_at"/>
        <br>
        update_at:<form:input path="update_at"/>
        <br>
        <input type="submit" value="Submit"/>
    </form:form>
<hr>
</body>
</html>
