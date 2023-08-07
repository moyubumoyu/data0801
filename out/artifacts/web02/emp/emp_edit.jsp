<%--
  Created by IntelliJ IDEA.
  User: 12244
  Date: 2023/7/26
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
    }
    h1 {
        text-align: center;
        margin-top: 30px;
    }
    form {
        max-width: 500px;
        margin: 0 auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }
    label {
        display: block;
        margin-bottom: 10px;
        font-weight: bold;
    }
    input[type="text"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        margin-bottom: 20px;
    }
    button {
        padding: 10px 20px;
        background-color: #4CAF50;
        color: #fff;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    button:hover {
        background-color: #45a049;
    }
    .cancel-button {
        background-color: #ccc;
        margin-right: 10px;
    }
</style>
<body>
<h1>编辑员工信息</h1>
<form id="editEmployeeForm">
    <label for="employeeId">员工编号:</label>
    <input type="text" id="employeeId" name="employeeId" disabled>
    <label for="name">姓名:</label>
    <input type="text" id="name" name="name">
    <label for="salary">薪资:</label>
    <input type="text" id="salary" name="salary">
    <label for="hireDate">入职日期:</label>
    <input type="text" id="hireDate" name="hireDate">
    <label for="departmentId">所属部门编号:</label>
    <input type="text" id="departmentId" name="departmentId">
    <button type="submit">保存</button>
    <button class="cancel-button" onclick="cancelEdit()">取消</button>
</form>
</body>
</html>
