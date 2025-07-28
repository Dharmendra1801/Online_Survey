package com.Project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddSurvey")
public class AddSurvey extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		HttpSession sess = request.getSession();
		String email = (String) sess.getAttribute("email");
		
		String ques = request.getParameter("ques");
		String ops = request.getParameter("options");
		
		String[] temp = ops.split(";");
		
		ArrayList<Options> op = new ArrayList<>();
		Long count = dao.getCount(email);
		String surID = email+"@"+String.valueOf(count+1);
		
		for (String option: temp) {
			Options O = new Options();
			O.setOption(option.trim());
			O.setSurveyID(surID);
			op.add(O);
		}
		
		SurveyDetails s = new SurveyDetails();
		s.setEmail(email);
		s.setQuestion(ques);
		s.setSurveyID(surID);
		
		dao.addSurvey(op,s);
		response.sendRedirect("Profile.jsp");
	}

}
