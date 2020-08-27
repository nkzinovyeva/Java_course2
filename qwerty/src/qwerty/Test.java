package qwerty;

import dataAccess.*;

public class Test {

	public static void main(String[] args) {
		
		System.out.println("fee44576");
		
		StudentDAO studentDAO = new StudentDAO();
		
		System.out.println(studentDAO.getAllStudentsJSON());

	}

}
