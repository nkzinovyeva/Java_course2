package servlet_exercises;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Student;

/**
 * Servlet implementation class JsonServlet
 */
@WebServlet("/jsontest")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		Student a = new Student(70, "John", "Lennon", "Baker Street, 24", "LONDON", "00180");
		Student b = new Student(80, "Ringo", "Star", "Beatles Street, 10", "LIVERPOOL", "12345");

		List<Student> studentList = new ArrayList<Student>();
		studentList.add(a);
		studentList.add(b);
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(studentList);

		Gson gson = new Gson();
		String jsonstring = gson.toJson(studentList);
		
		out.print(jsonstring);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/

}
