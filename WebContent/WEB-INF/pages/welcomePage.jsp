<%@page session="false"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title>Employee Twitter :: Welcome</title>
</head>

<body style="margin: 0px;background-color:lightblue">
  <jsp:include page="_menu.jsp" />


  <div style="margin-left:30px;">
    <h4>Welcome to Intuit Twitter - A twitter for employees.</h4>
  </div>
  <div style="margin-left:30px">
       <h3 style="color: Red;">Public Tweets</h3>

	<c:forEach var="tweet" items="${listTweets}" varStatus="status">
      <p><b>${tweet.user_username}:</b> ${tweet.tweet}
    </c:forEach>
  </div>
</body>
</html>