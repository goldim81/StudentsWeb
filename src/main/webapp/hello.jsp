<%--
  Created by IntelliJ IDEA.
  User: Demon
  Date: 011 11.10.17
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title hello</title>
</head>
<body>
<%= request.getParameter("login")%>
<c:forTokens var="message" items = "Artem, Vladimir,avel" delims = ", ">
<c:out value="${message}"/>
</c:forTokens>>
<c:forEach items="${list}" var="item">
    <p><c:out value="${item.getFirstName()}"></c:out></p>
</c:forEach>
</body>
</html>