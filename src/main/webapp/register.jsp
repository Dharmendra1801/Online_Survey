<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <style>
        .register-box {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0,0,0,0.2);
            width: 350px;
            margin: 80px auto;
            text-align: center;
        }

        .register-box h2 {
            margin-bottom: 20px;
            color: #333;
        }

        .register-box input[type="text"],
        .register-box input[type="email"],
        .register-box input[type="password"] {
            width: 90%;
            padding: 10px;
            margin: 10px 0;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        .register-box input[type="submit"] {
            width: 95%;
            padding: 10px;
            background-color: #3498db;
            color: white;
            font-weight: bold;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 15px;
        }

        .register-box a {
            text-decoration: none;
            color: #3498db;
            font-size: 14px;
        }

        body {
            background-color: #e0f7fa;
            font-family: Arial, sans-serif;
        }
    </style>
</head>
<body>
    <div class="register-box">
        <h2>Create Your Account</h2>
        <form action="RegisterServlet" method="post">
            <input type="text" name="name" placeholder="Full Name" required><br>
            <input type="email" name="email" placeholder="Email" required><br>
            <input type="password" name="password" placeholder="Password" required><br>
            <input type="password" name="confirmPassword" placeholder="Confirm Password" required><br>
            <input type="submit" value="Register">
        </form>
        <p>Already registered? <a href="login.jsp">Login here</a></p>
    </div>
</body>
</html>
