<%--
  Created by IntelliJ IDEA.
  User: 姚远
  Date: 2017/8/23
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>学生信息</h2>
<hr>
<%--action对应的内容是所操作的方法的url，如果URL不一致，则操作不成功--%>
<form:form action="${pageContext.request.contextPath}/up" method="put" modelAttribute="student">
    <input hidden name="_method" value="put">
    ID:${student.id}<br/>
    ID:<form:input path="id"/><br/>
    姓名:${student.name}<br/>
    姓名:<form:input path="name"/><br/>
    QQ:${student.qq}<br/>
    QQ:<form:input path="qq"/><br/>
    类型:${student.type}<br/>
    类型:<form:input path="type"/><br/>
    时间:${student.time}<br/>
    时间:<form:input path="time"/><br/>
    学校:${student.school}<br/>
    学校:<form:input path="school"/><br/>
    学号:${student.number}<br/>
    学号:<form:input path="number"/><br/>
    链接:${student.link}<br/>
    链接:<form:input path="link"/><br/>
    宣言:${student.hope}<br/>
    宣言:<form:input path="hope"/><br/>
    辅导师兄:${student.referrer}<br/>
    辅导师兄:<form:input path="referrer"/><br/>
    何处知晓:${student.from_where}<br/>
    何处知晓:<form:input path="from_where"/><br/>
    创建时间:${student.create_at}<br/>
    创建时间:<form:input path="create_at"/><br/>
    更新时间:${student.update_at}<br/>
    更新时间:<form:input path="update_at"/><br/>
    <input type="submit" value="提交">

</form:form>
<hr>

</body>
</html>
