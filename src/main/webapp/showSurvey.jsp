<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Surveys</title>
</head>
<body>

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
		if (session.getAttribute("email")==null) response.sendRedirect("login.jsp");
	%>
    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>Question</th>
            <th>Options</th>
        </tr>
        <%
        	@SuppressWarnings("unchecked")
            Map<String, List<String>> hm = (Map<String, List<String>>) request.getAttribute("result");
            if (hm != null) {
                for (String q : hm.keySet()) {
        %>
        <tr>
            <td><%= q %></td>
            <td>
                <%
                    List<String> options = hm.get(q);
                    if (options != null) {
                        for (String o : options) {
                %>
                    <%= o %><br>
                <%
                        }
                    }
                %>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>
