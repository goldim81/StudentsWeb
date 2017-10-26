<%--
  Created by IntelliJ IDEA.
  User: Demon
  Date: 012 12.10.17
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register user</title>
</head>
<body>
<form id = "register_form" method="post" action = "/student/register">
<input type="text" name="login" />
<input type = "password" name = "password">
<input type="submit" value = "register">
</form>

</body>
</html>
