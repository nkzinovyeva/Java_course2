package database_programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import data_access.ConnectionParameters;
import data_access.DbUtils;

public class SimpleStudentInsertProgram {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		System.out.println("=== Add student ===");
		System.out.print("Id: ");
		int id = Integer.parseInt(input.nextLine());

		System.out.print("First name: ");
		String firstname = input.nextLine();

		System.out.print("Last name: ");
		String lastname = input.nextLine();

		System.out.print("Street: ");
		String streetaddress = input.nextLine();

		System.out.print("Postcode: ");
		int postcode = Integer.parseInt(input.nextLine());
		;

		System.out.print("Post office: ");
		String postoffice = input.nextLine();

		try {
			connection = DriverManager.getConnection(ConnectionParameters.connectionString,
					ConnectionParameters.username, ConnectionParameters.password);

			String sqlText = "INSERT INTO Student (id, firstname, lastname, streetaddress, postcode, postoffice) VALUES (?, ?, ?, ?, ?, ?)";

			preparedStatement = connection.prepareStatement(sqlText);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, firstname);
			preparedStatement.setString(3, lastname);
			preparedStatement.setString(4, streetaddress);
			preparedStatement.setInt(5, postcode);
			preparedStatement.setString(6, postoffice);

			preparedStatement.executeUpdate();
			

			System.out.println("Student data added!");

		} catch (SQLException sqle) {
			// First, check if the problem is primary key violation (the error code is
			// vendor-dependent)
			if (sqle.getErrorCode() == ConnectionParameters.PK_VIOLATION_ERROR) {
				System.out.println("Cannot insert the student. The student id " + id + " is already in use");
			} else {
				System.out.println(
						"The database is temporarily unavailable. Please try again later." + sqle.getMessage());
			}

		} finally {
			DbUtils.closeQuietly(preparedStatement, connection);
		}
		input.close();
	}
}
// End