<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title>Mini Twitter :: Delete Tweets</title>
  <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
</head>
<body style="margin: 0px;background-color:lightblue">
  <jsp:include page="../_menu.jsp" />

  <div style="margin-left:0px;">
    <br/>
    <b>
    	<a href="${pageContext.request.contextPath}/tweet/new" style="text-decoration:none; color: black; margin-left: 30px;">Compose New Tweet</a>
    	&nbsp | &nbsp
    	<a href="${pageContext.request.contextPath}/tweets/all" style="text-decoration:none; color: black;">Read Tweets</a>
    	&nbsp | &nbsp
    	<a href="${pageContext.request.contextPath}/following" style="text-decoration:none; color: black;">List Users I Follow</a>
    	&nbsp | &nbsp
    	<a href="${pageContext.request.contextPath}/followers" style="text-decoration:none; color: black;">List My Followers</a>
    	&nbsp | &nbsp
    	<a href="${pageContext.request.contextPath}/users" style="text-decoration:none; color: black;">Follow / Unfollow Users</a>
    	&nbsp | &nbsp
    	<a href="${pageContext.request.contextPath}/delete" style="text-decoration:highlight; color: red;">Delete Tweets</a>
 	</b>
 </div>
	<div style="margin-left:30px">
 	<br/>
       <h2 style="color: grey;">All Tweets</h2>

    <br/>
	<c:forEach var="tweet" items="${listTweets}" varStatus="status">
      <p><b>${tweet.user_username}:</b> ${tweet.tweet}
      <input type="button" value="Delete" style="margin-left: 10px;" onClick="tweet('${tweet.user_username},${tweet.tweet}')">
    </c:forEach>
  </div>

  <script>
  	function tweet(user_username,tweet){
      //var tweet = document.getElementById("tweet").value;
      $.post("${pageContext.request.contextPath}/deleteTweet",
    		  {tweet:user_username},{tweet:tweet}).always(function(data){
    			  alert(data.message);
        		  window.location = "${pageContext.request.contextPath}/tweets/all";
      });
    }
 
  </script>
</body>
</html>