<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
  <title>Employee Twitter :: Tweets</title>
  <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
</head>
<body style="margin: 0px;background-color:lightblue">
  <jsp:include page="../_menu.jsp" />

<!--   <div style="margin-left:30px; margin-top: 30px;"> -->
  <div style="margin-left:0px;">
    <br/>
    <b>
    	<a href="${pageContext.request.contextPath}/tweet/new" style="text-decoration:none; color: black; margin-left: 30px;">Compose New Tweet</a>
    	&nbsp | &nbsp
    	<a href="${pageContext.request.contextPath}/tweets/all" style="text-decoration:highlight; color: red;">Read Tweets</a>
    	&nbsp | &nbsp
    	<a href="${pageContext.request.contextPath}/following" style="text-decoration:none; color: black;">List Users I Follow</a>
    	&nbsp | &nbsp
    	<a href="${pageContext.request.contextPath}/followers" style="text-decoration:none; color: black;">List My Followers</a>
    	&nbsp | &nbsp
    	<a href="${pageContext.request.contextPath}/users" style="text-decoration:none; color: black;">Follow / Unfollow Users</a>
    	&nbsp | &nbsp
    	<a href="${pageContext.request.contextPath}/delete" style="text-decoration:none; color: black;">Delete Tweets</a>
 	</b>
 	</div>

	<div style="margin-left:30px">
    	<c:choose>
      		<c:when test="${not empty username}">
        		<h1 style="color: grey;">${username} Tweets</h1>
      		</c:when>

      		<c:otherwise>
        		<h1 style="color: grey;" >Public Tweets</h1>
      		</c:otherwise>
   	 	</c:choose>
	
    <h3>Search tweets by user and keyword:</h3>

    <form id="search_form">
      <b>User:</b>
      <input type="text" id="username" value="${username}" placeholder="Insert username" />
      <b style="margin-left: 25px;">Keyword:</b>
      <input type="text" id="search" value="${search}" placeholder="Insert keyword"/>
      <input type="submit" value="Search" style="margin-left: 25px;"/>
    </form>

    <c:forEach var="tweet" items="${listTweets}" varStatus="status">
      <p><b>${tweet.user_username}:</b> ${tweet.tweet}
    </c:forEach>
    </div>

  <script type="text/javascript">
    $('#search_form').submit(function (e) {
      // Stop from submitting
      e.preventDefault();

      var username = $('#username').val();
      var search = $('#search').val();

      if(username == ""){
          window.location = "${pageContext.request.contextPath}/tweets/all?search=" + search;
      }
      else {
          window.location = "${pageContext.request.contextPath}/tweets/" + username + "?search=" + search;
      }
    });
  </script>
</body>
</html>