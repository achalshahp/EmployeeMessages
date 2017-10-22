<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title>Employee Twitter :: New Tweet</title>
  <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
</head>
<<<<<<< HEAD
<body style="margin: 0px;background-color:lightblue">
  <jsp:include page="../_menu.jsp" />

  <div style="margin-left:0px;">
    <br/>
    <b>
    	<a href="${pageContext.request.contextPath}/tweet/new" style="text-decoration:highlight; color: red; margin-left: 30px;">Compose New Tweet</a>
    	&nbsp | &nbsp
    	<a href="${pageContext.request.contextPath}/tweets/all" style="text-decoration:none; color: black;">Read Tweets</a>
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
 	<br/><br/>
 	<div style="margin-left:30px">
 		<table>
      	<tr>
       		<td><b>What's on your mind:</b></td>
        	<td><textarea id="tweet" name="tweet" maxlength="140" rows="3" cols="50"/></textarea></td>
      	</tr>
      	<tr>
        	<td></td>
        	<td><span style="font-size: 10pt; color: grey;">* Maximum 140 characters</span></td>
      	</tr>
      	<tr>
        	<td>
          		<br/><input type="button" value="Tweet" style="margin-left: 10px;" onClick="tweet()">
        	</td>
      	</tr>
    	</table>
    </div>
 </div>
=======
<body style="margin: 0px;">
  <jsp:include page="../_menu.jsp" />

  <div style="margin-left:30px; margin-top: 30px;">
    <h1 style="color: grey;">Compose New Tweet</h1><br/>
    <table>
      <tr>
        <td><b>Name:</b></td>
        <td><textarea id="tweet" name="tweet" maxlength="140" rows="3" cols="50"/></textarea></td>
      </tr>
      <tr>
        <td></td>
        <td><span style="font-size: 10pt; color: grey;">* Maximum 140 characters</span></td>
      </tr>
      <tr>
        <td>
          <br/><input type="button" value="Tweet" style="margin-left: 10px;" onClick="tweet()">
        </td>
      </tr>
    </table>
  </div>
>>>>>>> 7e3c89a3fdc3c01a583d31dbb6ac23104d6ed3f4
  <script>
    function tweet(tweet){
      var tweet = document.getElementById("tweet").value;
      $.post("${pageContext.request.contextPath}/tweet/create",{tweet:tweet,commandName:"tweetForm"}).always(function(data){
        alert(data.message);
<<<<<<< HEAD
        window.location = "${pageContext.request.contextPath}/tweets/all";
=======
        window.location = "${pageContext.request.contextPath}/index";
>>>>>>> 7e3c89a3fdc3c01a583d31dbb6ac23104d6ed3f4
      });
    }
  </script>
</body>
</html>