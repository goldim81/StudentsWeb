<%--
  Created by IntelliJ IDEA.
  User: Demon
  Date: 012 12.10.17
  Time: 1:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление студента</title>
</head>
<body>
<form name="edit_form" method="post" action="/student/addstudent">
    <input type="text" name="id" value="${student.getId()}">
    <input type="text" name="firstname" value="${student.getFirstName()}">
    <input type="text" name="secondname" value="${student.getSecondName()}">
    <input type="text" name="familyname" value="${student.getFamilyName()}">
    <input type="text" name="birthday" value="${student.getBdate()}">
    <input type="text" name="groupid" value="${student.getGroupId()}">
    <input type="submit" value = "add">
</form>
</body>
</html>
