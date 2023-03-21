<%--
  Created by IntelliJ IDEA.
  User: hyunsoolim
  Date: 2023/03/21
  Time: 10:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello World</title>
</head>
<body>
    <h2>Hello World</h2>
    <hr>
    현재 날짜와 시간은
    <%=java.time.LocalDateTime.now()%>
    입니다.
</body>
</html>
