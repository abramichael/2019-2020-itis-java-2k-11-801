<%--
  Created by IntelliJ IDEA.
  User: ma
  Date: 11.10.2019
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
        <% if (request.getAttribute("name") != null) { %>
            Hello, ${name}!
        <% } else { %>
            Hello, anon!
        <% } %>
</body>
</html>
