<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Profile - Online Survey</title>
    <link rel="stylesheet" type="text/css" href="Profile.css">
</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
	if (session.getAttribute("email")==null) response.sendRedirect("login.jsp");
%>
<div class="profile-box">
    <h2>Welcome <%= session.getAttribute("name") %> </h2>

    <form action="AddSurvey.jsp" method="post">
    <input type="submit" value="Add Survey">
    </form>
    <br>
    <form action="AddSurvey" method="post">
    <input type="submit" value="Your Surveys">
    </form>
    <br>
    <form action="LogoutServlet">
    <input type="submit" value="logout">
    </form>
</div>
</body>
</html>

