package database_programs;

import java.util.Scanner;

import data_access.StudentDAO;
import model.Student;

public class StudentInsertProgram {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("=== Add student (DAO version) ===");
		
		System.out.print("Id: ");
		int id = Integer.parseInt(input.nextLine());

		System.out.print("First name: ");
		String firstname = input.nextLine();

		System.out.print("Last name: ");
		String lastname = input.nextLine();

		System.out.print("Street: ");
		String streetaddress = input.nextLine();

		System.out.print("Postcode: ");
		String postcode = input.nextLine();
		
		System.out.print("Post office: ");
		String postoffice = input.nextLine();
		
		Student student = new Student(id, firstname, lastname, streetaddress, postcode, postoffice);
		
		StudentDAO studentDAO = new StudentDAO();
		
		int result = studentDAO.insertStudent(student);
		
		if (result == 1) {
			System.out.println("Cannot insert the student. The student id \" + id + \" is already in use");
		} else if (result == 0) {
			System.out.println("Student data added!");
		} else {
			System.out.println("The database is temporarily unavailable. Please try again later.");
		}
		input.close();
	}

}
