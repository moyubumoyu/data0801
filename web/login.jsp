<%--
  Created by IntelliJ IDEA.
  User: 12244
  Date: 2023/7/27
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            /* background-color: #f2f2f2;*/
            background-image: url('/img/1.png');
        }


        .container {
            width: 400px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #fff;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            animation: fadein 1s;
        }
        @keyframes fadein {
            from { opacity: 0; }
            to   { opacity: 1; }
        }
        .container h2 {
            text-align: center;
            color: #333;
        }
        .container input[type="text"],
        .container input[type="password"] {
            width: 95%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        .container input[type="checkbox"] {
            margin-bottom: 10px;
        }
        .container input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .container input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>${msg==null?'登录':msg}</h2>
    <form action="/web02/Login" method="post">
        <input type="text" placeholder="Username" name="username" value="${cookie.uname.value}"  required>
        <input type="password" placeholder="Password" name="password" value="${cookie.pwd.value}" required>
        <label for="remember" style="color: #666;">Remember Me</label>
        <input type="checkbox" id="remember" name="remember" value="yes">
        <input type="submit" value="Login">
    </form>
</div>
</body>
</html>
