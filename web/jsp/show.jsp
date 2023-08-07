<%--
  Created by IntelliJ IDEA.
  User: 12244
  Date: 2023/8/1
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>当前登录的用户:${username}</h2>
<h2>当前在线人数${list.size()},用户列表如下</h2>
<ul>
    <c:if test="${list!=null}">
        <%--
           item:要遍历的集合
           var:从集合中获取到的每一个元素
        --%>
        <c:forEach items="${list}" var="name">
            <li>${name}</li>
        </c:forEach>
    </c:if>
</ul>
<a href="/web02/logout">注销</a>
</body>
</html>
