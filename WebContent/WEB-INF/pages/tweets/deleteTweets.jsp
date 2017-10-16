<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title>Mini Twitter :: Delete Tweets</title>
  <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
</head>
<body style="margin: 0px;">
  <jsp:include page="../_menu.jsp" />

  <div style="margin-left:30px; margin-top: 30px;">

    <h1 style="color: grey;">Delete Tweets</h1>
 <%--    
    <c:if test="${not empty notice}">
      ${notice}
      
      
     
    </c:if>
    
    <br/>

    <c:forEach var="user" items="${listUsers}" varStatus="status">
      <p>
        <c:choose>
          <c:when test="${user.status == false}">
            <b>User: </b>${user.username}
            <input type="button" value="Follow" style="margin-left: 10px;" onClick="follow('${user.username}')">
          </c:when>

          <c:otherwise>
            <b>User: </b>${user.username}
            <input type="button" value="Unfollow" style="margin-left: 10px;" onClick="unfollow('${user.username}')">
          </c:otherwise>
        </c:choose>
        <br/>
      </p>
    </c:forEach>
    
    <script>
    function follow(username){
      $.post("${pageContext.request.contextPath}/users/follow",{username:username,commandName:"followForm"}).always(function(data){
        alert(data.message);
        location.reload();
      });
    }

    function unfollow(username){
      $.post("${pageContext.request.contextPath}/users/unfollow",{username:username,commandName:"unfollowForm"}).always(function(data){
        alert(data.message);
        location.reload();
      });
    }
  </script> --%>
    
    <%-- <c:if test="${not empty notice}">
      ${notice}
    </c:if>

    <br/>

    <c:forEach var="user" items="${listUsers}" varStatus="status">
      <p>
        <c:choose>
          <c:when test="${user.status == false}">
            <b>User: </b>${user.username}
            <input type="button" value="Follow" style="margin-left: 10px;" onClick="follow('${user.username}')">
          </c:when>

          <c:otherwise>
            <b>User: </b>${user.username}
            <input type="button" value="Unfollow" style="margin-left: 10px;" onClick="unfollow('${user.username}')">
          </c:otherwise>
        </c:choose>
        <br/>
      </p>
    </c:forEach>
  </div>
 --%>
 	
 	<h4> NOW I AM INSIDE THE DELTE PAGE</h4>
 	
 	
    
    <c:choose>
      <c:when test="${not empty username}">
        <h1 style="color: grey;">${username} Tweets</h1>
      </c:when>

      <c:otherwise>
        <h1 style="color: grey;">All Tweets</h1>
      </c:otherwise>
    </c:choose>

    <br/>

	<c:forEach var="tweet" items="${listTweets}" varStatus="status">
      <p><b>${tweet.user_username}:</b> ${tweet.tweet}
      <input type="button" value="Delete" style="margin-left: 10px;" onClick="tweet('${tweet.user_username},${tweet.tweet}')">
    </c:forEach>
  </div>
  <h3> done with printing all users</h3>
  

  <script>
  	function tweet(user_username,tweet){
      //var tweet = document.getElementById("tweet").value;
      $.post("${pageContext.request.contextPath}/deleteTweet",
    		  {tweet:user_username},{tweet:tweet}).always(function(data){
    			  alert(data.message);
        		  window.location = "${pageContext.request.contextPath}/index";
        //location.reload();
        //window.location = "${pageContext.request.contextPath}/index";
      });
    }
    /* function Tweet(user_username,tweet){
      
      $.post("${pageContext.request.contextPath}/deleteTweet",{tweet:user_username},{tweet:tweet, commandName:"deleteForm"}).always(function(data){
    	  alert(data.message);
    	  //window.location = "${pageContext.request.contextPath}/index"
    	  location.reload();
      });
    } */

  </script>
</body>
</html>