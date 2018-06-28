<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.*"%>
<html>
<head>
    <title>登出</title>
</head>
<body>
<%
    String phone= (String) session.getAttribute("phone");
    session.setAttribute("phone",null);
    response.sendRedirect("../index.jsp");
%>
</body>
</html>
