<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<<<<<<< HEAD
<div style="background-color: rgb(0,0,255);">
  <h2 style="display: inline-block; margin-left: 30px;">
    <c:choose>
      <c:when test="${pageContext.request.userPrincipal.name != null}">
        <a href="${pageContext.request.contextPath}/feed" style="text-decoration:none; color: black;">Employee Twitter</a>
=======
<div style="background-color: lightgrey; height: 7%;">
  <h2 style="display: inline-block; margin-left: 30px;">
    <c:choose>
      <c:when test="${pageContext.request.userPrincipal.name != null}">
        <a href="${pageContext.request.contextPath}/index" style="text-decoration:none; color: black;">Employee Twitter</a>
>>>>>>> 7e3c89a3fdc3c01a583d31dbb6ac23104d6ed3f4
      </c:when>

      <c:otherwise>
        <a href="${pageContext.request.contextPath}/" style="text-decoration:none; color: black;">Employee Twitter</a>
      </c:otherwise>
    </c:choose>
  </h2>

  <div style="float: right; line-height:65px; margin-right: 30px;">
    <c:choose>
      <c:when test="${pageContext.request.userPrincipal.name != null}">
        <a href="${pageContext.request.contextPath}/logout" style="text-decoration:none; color: black;">Logout</a>
      </c:when>

      <c:otherwise>
        <a href="${pageContext.request.contextPath}/login" style="text-decoration:none; color: black;">Login</a>
      </c:otherwise>
    </c:choose>
<<<<<<< HEAD
   </div>
    

=======
  </div>
>>>>>>> 7e3c89a3fdc3c01a583d31dbb6ac23104d6ed3f4
</div>