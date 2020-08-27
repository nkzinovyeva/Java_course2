package servletExercises;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataAccess.StudentDAO;

/**
 * Servlet implementation class StudentDeleteServlet
 */
@WebServlet("/deleteStudent")
public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		
		StudentDAO studentDAO = new StudentDAO();
		
		int errorCode = studentDAO.deleteStudent(id);
		
		out.print(errorCode);
		//out.print("{\"errorCode\": " + errorCode + " }");
	}

}
