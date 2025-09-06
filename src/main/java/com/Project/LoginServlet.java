package com.Project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		DAO dao = new DAO();
		int ans = dao.checkCredentials(email, password);
		if (ans==0) response.sendRedirect("login.jsp");
		else if (ans==-1) response.sendRedirect("index.jsp");
		else { 
			HttpSession s = request.getSession();
			s.setAttribute("email", email);
			s.setAttribute("name", dao.getName(email));
			response.sendRedirect("Profile.jsp");
		}
	}

}
