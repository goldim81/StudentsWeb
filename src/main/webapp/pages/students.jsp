<%--
  Created by IntelliJ IDEA.
  User: Demon
  Date: 011 11.10.17
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Список студентов</title>
    <!-- Последняя компиляция и сжатый CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Дополнение к теме -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Последняя компиляция и сжатый JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse; }
        th, td {
            padding: 5px; }
        th {
            text-align: left; }
    </style>
</head>
<body>
<form name="list_students">
<table class="table table-bordered table-striped">
    <thead>
        <th width="100">Id</th> <th>Имя</th> <th>Фамилия</th> <th>Отчество</th> <th>День Рождения</th> <th>Id Группы</th> <th>действие</th>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="item">
        <tr>
            <th scope="row"><c:out value="${item.id}"></c:out></th>
            <td><c:out value="${item.firstname}"></c:out></td>
            <td><c:out value="${item.lastname}"></c:out></td>
            <td><c:out value="${item.secondname}"></c:out></td>
            <td><c:out value="${item.birthday}"></c:out></td>
            <td><c:out value="${item.group_id}"></c:out></td>
            <td>
                <button type="submit" class="btn btn-danger" name="del_by_id" value="${item.id}" formaction="/student/delstudent">
                    <span class="glyphicon glyphicon-trash"></span>
                </button>
                <button type="submit" class="btn btn-primary" name="edit_by_id" value="${item.id}" formaction="/student/editstudent">
                    <span class="glyphicon glyphicon-edit"></span>
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</form>
<form name="add_form" action="/student/addstudent">
    <button type="submit" class="btn btn-primary" name="add_student">
        <span class="glyphicon glyphicon-plus"></span>
        Добавить
    </button>
</form>
</body>
</html>
