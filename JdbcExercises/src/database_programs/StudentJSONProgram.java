package database_programs;

import data_access.StudentDAO;

public class StudentJSONProgram {

	public static void main(String[] args) {
		
		StudentDAO studentDAO = new StudentDAO();
		
		System.out.println(studentDAO.getAllStudentsJSON());

	}

}
