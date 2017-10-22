<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
  <title>Employee Twitter :: Unauthorised</title>
</head>
<body>
  <br/><br/>
  <div style="margin-left:20%;">
    <h1 style="font-size: 70pt;">Oops!</h1>

    <h1>Unauthorized User. Please login using proper credentials to use this feature.</h1>

    <h4 style="color: grey;">Error code: 401 - Unauthorised</h4>
    <br/><br/>
    <a href="${pageContext.request.contextPath}/">Back To Home</a>
  </div>
</body>
</html>