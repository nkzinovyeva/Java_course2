package database_programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import data_access.ConnectionParameters;
import data_access.DbUtils;

public class SimpleStudentDeleteProgram {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;

		System.out.println("=== delete student ===");
		System.out.print("Enter student id: ");
		
		int givenId = Integer.parseInt(input.nextLine());
		
		try {
			// 1. Open a database connection
			connection = DriverManager.getConnection(ConnectionParameters.connectionString,
					ConnectionParameters.username, ConnectionParameters.password);

			// 2. Define the SQL query text (NB! Exclamation mark is used as a place-holder
			// for a parameter value)
			String sqlText = "DELETE from Student WHERE id = ?";

			// 3. Create a prepared statement based on the SQL query text
			preparedStatement = connection.prepareStatement(sqlText);

			// 4. Set the query parameter value(s) based on the place-holder number(s)
			preparedStatement.setInt(1, givenId);

			// 5. Execute the SQL query with the PreparedStatement object
			result = preparedStatement.executeUpdate();

			if (result == 0) {
				System.out.println("Nothing deleted. Unknown student id (" + givenId + ")");
			}
			else {
				System.out.println("Student deleted!");
			}

		} catch (SQLException sqle) {
			// 8. If any JDBC operation fails, we display an error message here
			System.out.println("\n[ERROR] Database error. " + sqle.getMessage());

		} finally {
			// 9. The resources should be closed as soon as we don't need them anymore
			DbUtils.closeQuietly(preparedStatement, connection);
		}
		input.close();
	}
}