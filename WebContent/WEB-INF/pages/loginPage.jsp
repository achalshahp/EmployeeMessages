<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
  <title>Employee Twitter :: Login</title>
</head>
<<<<<<< HEAD
<body style="margin: 0px;background-color:lightblue">
  <jsp:include page="_menu.jsp" />

  <div style="margin-left:30px;">

    <h1>Login</h1>
	<h4>Please use your corp credentials to login.</h4>
=======
<body style="margin: 0px;">
  <jsp:include page="_menu.jsp" />

  <div style="margin-left:30px; margin-top: 30px;">

    <h1>Login</h1>

>>>>>>> 7e3c89a3fdc3c01a583d31dbb6ac23104d6ed3f4
    <c:if test="${param.error == 'true'}">
      <div style="color:grey;margin:10px 0px;">
        Login Failed!!!<br/>
        Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
      </div>
    </c:if>

    <form name='f' action="${pageContext.request.contextPath}/dologin" method='POST'>
      <table>
        <tr>
          <td><b>User:</b></td>
          <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
          <td><b>Password:</b></td>
          <td><input type='password' name='password' /></td>
        </tr>
        <tr>
          <td><br/><input name="submit" type="submit" value="Login" /></td>
        </tr>
      </table>
    </form>
  </div>
</body>
</html>