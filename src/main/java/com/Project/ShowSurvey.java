package com.Project;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.Project.Entity.SurveyDetails;

@WebServlet("/ShowSurveys")
public class ShowSurvey extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAO dao = new DAO();
		HttpSession s = request.getSession();
		Map<String,List<String>> result = new HashMap<>();
		
		List<Object[]> list = dao.getAllSurveyQ((String) s.getAttribute("email"));
		
		for (Object[] survey: list) {
			result.put((String) survey[1],dao.getOptions((String) survey[0]));
		}
		
		
		request.setAttribute("result",result);
		
		request.getRequestDispatcher("showSurvey.jsp").forward(request, response);
	}

}
