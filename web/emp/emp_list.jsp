<%--
  Created by IntelliJ IDEA.
  User: 12244
  Date: 2023/7/26
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>员工信息</title>
    <style>
        table {
            width: 70%;
            border-collapse: collapse;
            margin-top: 10px;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        button {
            padding: 5px 10px;
            margin-right: 5px;
        }
        #btn{
            position: relative;
            left: 300px;
        }
        #btn{
            position: relative;
            left: 500px;
        }
    </style>
</head>
<body>
<center>
    <h1>员工信息</h1>
</center>
<button id="btn" onclick="">添加员工</button>

<table align="center">
    <tr>
        <th>员工编号</th>
        <th>姓名</th>
        <th>薪资</th>
        <th>入职日期</th>
        <th>所属部门编号</th>
        <th>操作</th>
    </tr>

    <c:if test="${empList!=null}">
        <c:forEach items="${empList}" var="emp">
            <tr>
                <td>${emp.employeeId}</td>
                <td>${emp.name}</td>
                <td>${emp.salary}</td>
                <td>${emp.hireDate}</td>
                <td>${emp.departmentId}</td>
                <td>
                    <button onclick="editEmployee(1)">编辑</button>
                    <button onclick="deleteEmployee(1)">删除</button>
                </td>
            </tr>
        </c:forEach>
    </c:if>


    <!-- Add more rows for other employees -->
</table>

<script>

</script>
</body>
</html>
