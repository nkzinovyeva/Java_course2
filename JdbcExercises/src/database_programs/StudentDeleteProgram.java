package database_programs;

import java.util.Scanner;

import data_access.StudentDAO;

public class StudentDeleteProgram {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("=== delete student (DAO version) ===");
		System.out.print("Enter student id: ");

		int givenId = Integer.parseInt(input.nextLine());

		StudentDAO studentDAO = new StudentDAO();

		int result = studentDAO.deleteStudent(givenId);

		if (result == 1) {
			System.out.println("Nothing deleted. Unknown student id (" + givenId + ")");
		} else if (result == 0) {
			System.out.println("Student deleted!");
		} else {
			System.out.println("The database is temporarily unavailable. Please try again later.");
		}
		input.close();
	}

}
