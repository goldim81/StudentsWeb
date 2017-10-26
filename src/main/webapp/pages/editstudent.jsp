<%--
  Created by IntelliJ IDEA.
  User: Demon
  Date: 012 12.10.17
  Time: 1:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>Редактирование записи</title>
    <!-- Последняя компиляция и сжатый CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Дополнение к теме -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Последняя компиляция и сжатый JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
    <form name="edit_form" method="post" action="/student/editstudent">
        <input type="text" id="id" name="id" value="${student.getId()} disable">
        <input type="text" id="firsname" name="firsname" value="${student.getFirstName()}">
        <input type="text" id="secondname" name="secondname" value="${student.getSecondName()}">
        <input type="text" id="familyname" name="familyname" value="${student.getFamilyName()}">
        <input type="text" id="birthday" name="birthday" value="${student.getBdate()}">
        <input type="text" id="groupid" name="groupid" value="${student.getGroupId()}">
        <input type="submit" value = "update">
    </form>
</div>
</body>
</html>
