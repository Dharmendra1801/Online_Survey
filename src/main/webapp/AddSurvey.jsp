<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add your Survey</title>
<link rel="stylesheet" type="text/css" href="Profile.css">
</head>
<body>
<div class="profile-box">
	<h3> Enter the question for your survey</h3>
    <form action="AddSurvey" method="post">
    	<input type = "text" name="ques" placeholder="Enter your questions"><br><br>
    	<input type = "text" name="options" placeholder="Enter your options separated by ';'"><br><br>
    	<input type = "submit" value="submit">
    </form>
</div>
</body>
</html>