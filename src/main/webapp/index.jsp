<%--
  Created by IntelliJ IDEA.
  User: Demon
  Date: 010 10.10.17
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Проект студенты</title>
    <!-- Последняя компиляция и сжатый CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Дополнение к теме -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Последняя компиляция и сжатый JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

  </head>
  <body>
  <div class="container">
      <div class="col-md-3">
      </div>
      <div class="col-md-6 ">
        <div class="panel panel-primary">
          <div class="panel-heading"><h3>Введите данные для входа</h3></div>
        <div class="panel-body">
      <form class="form-horizontal" method="post" action = "/student/auth">
          <div class="form-group">
            <label for="inputLogin" class="control-label col-md-3">Login</label>
            <div class="col-md-9">
              <input type="text" id="inputLogin" name="login" class="form-control" placeholder="Login" autofocus="true" autocomplete="off">
            </div>
          </div>
          <div class="form-group">
            <label for="inputPassword" class="control-label col-md-3">Password</label>
            <div class="col-md-9">
              <input type="password" id="inputPassword" name = "password" class="form-control" placeholder="Password" autocomplete="off">
            </div>
          </div>
        <div class="form-group">
          <div class="col-md-9 col-md-offset-3">
          <button class="btn btn-lg btn-primary" type="submit" value = "login">Войти</button>
          <button class="btn btn-lg btn-primary" type="submit" value = "register" formaction="/student/register.jsp">Регистрация</button>
          </div>
        </div>

      </form>
        </div>
        </div>
      </div>
    <div class="col-md-3">
    </div>
  </div> <!-- /container -->
  <%--<form id = "myForm" method="post" action = "/student/auth">--%>
  <%--<input type="text" name="login" />--%>
    <%--<input type = "password" name = "password">--%>
    <%--<input type="submit" value = "login">--%>
  <%--</form>--%>

  <%--<%double num = Math.random();%>--%>
  <%--<%=num%>--%>
  <%--<%=request.getRequestURI()%>--%>
  </body>
</html>
