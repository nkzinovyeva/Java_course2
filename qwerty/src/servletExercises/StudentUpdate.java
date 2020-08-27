package servletExercises;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataAccess.StudentDAO;
import model.Student;

/**
 * Servlet implementation class StudentUpdate
 */
@WebServlet("/updateStudent")
public class StudentUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String streetaddress = request.getParameter("streetaddress");
		String postcode = request.getParameter("postcode");
		String postoffice = request.getParameter("postoffice");
		int id = Integer.parseInt(request.getParameter("id"));

		StudentDAO studentDAO = new StudentDAO();

		Student student_new = new Student(id, firstname, lastname, streetaddress, postcode, postoffice);

		int errorCode = studentDAO.updateStudent(student_new);

		out.print(errorCode);
	}

}
