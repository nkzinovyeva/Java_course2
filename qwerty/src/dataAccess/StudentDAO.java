package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import model.Student;

public class StudentDAO {

	public StudentDAO() {
		// In Tomcat 8 environment, the JDBC driver must be explicitly loaded as below
		try {
			Class.forName(ConnectionParameters.jdbcDriver);
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}
	}

	private Connection openConnection() throws SQLException {
		return DriverManager.getConnection(ConnectionParameters.connectionString, ConnectionParameters.username,
				ConnectionParameters.password);
	}

	/**** GET STUDENTS ****/

	public List<Student> getStudents() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> studentList = new ArrayList<Student>();

		try {
			connection = openConnection();

			String sqlText = "SELECT id, firstname, lastname, streetaddress, postcode, postoffice FROM Student ORDER by lastname";

			preparedStatement = connection.prepareStatement(sqlText);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String streetaddress = resultSet.getString("streetaddress");
				String postcode = resultSet.getString("postcode");
				String postoffice = resultSet.getString("postoffice");

				studentList.add(new Student(id, firstname, lastname, streetaddress, postcode, postoffice));
			}

		} catch (SQLException sqle) {
			System.out.println("\n[ERROR] StudentDAO: getStudent() failed. " + sqle.getMessage() + "\n");
			studentList = null;

		} finally {
			DbUtils.closeQuietly(resultSet, preparedStatement, connection);
		}

		return studentList;
	}

	/**** GET STUDENTS BY ID ****/

	public List<Student> getStudentById(int givenId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> studentList = new ArrayList<Student>();

		try {
			connection = openConnection();

			String sqlText = "SELECT id, firstname, lastname, streetaddress, postcode, postoffice FROM Student WHERE id = ?";

			preparedStatement = connection.prepareStatement(sqlText);
			preparedStatement.setInt(1, givenId);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String streetaddress = resultSet.getString("streetaddress");
				String postcode = resultSet.getString("postcode");
				String postoffice = resultSet.getString("postoffice");

				studentList.add(new Student(id, firstname, lastname, streetaddress, postcode, postoffice));
			}

		} catch (SQLException sqle) {
			System.out.println("[ERROR] MovieDAO: getMoviesFromGivenYear() failed. " + sqle.getMessage() + "\n");
			studentList = null;

		} finally {
			DbUtils.closeQuietly(resultSet, preparedStatement, connection);
		}

		return studentList;
	}

	/**** GET STUDENTS JSON ****/

	public String getAllStudentsJSON() {

		StudentDAO studentDAO = new StudentDAO();

		List<Student> studnetList = studentDAO.getStudents();

		Gson gson = new Gson();
		String json = gson.toJson(studnetList);

		return json;
	}

	/**** INSERT STUDENTS ****/

	public int insertStudent(Student student) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int errorCode = -1;

		try {
			connection = openConnection();

			String sqlText = "INSERT INTO Student (id, firstname, lastname, streetaddress, postcode, postoffice) VALUES (?, ?, ?, ?, ?, ?)";

			preparedStatement = connection.prepareStatement(sqlText);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getFirstname());
			preparedStatement.setString(3, student.getLastname());
			preparedStatement.setString(4, student.getStreetaddress());
			preparedStatement.setString(5, student.getPostcode());
			preparedStatement.setString(6, student.getPostoffice());

			System.out.println(student);

			preparedStatement.executeUpdate();
			errorCode = 0;

		} catch (SQLException sqle) {
			if (sqle.getErrorCode() == ConnectionParameters.PK_VIOLATION_ERROR) {
				errorCode = 1;
			} else {
				System.out.println(
						"The database is temporarily unavailable. Please try again later." + sqle.getMessage() + "\n");
				errorCode = -1;
			}

		} finally {
			DbUtils.closeQuietly(preparedStatement, connection);
		}

		return errorCode;
	}

	/**** DELETE STUDENTS ****/

	public int deleteStudent(int studentId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = -1;

		try {
			connection = openConnection();

			String sqlText = "DELETE from Student WHERE id = ?";

			preparedStatement = connection.prepareStatement(sqlText);

			preparedStatement.setInt(1, studentId);

			result = preparedStatement.executeUpdate();

			if (result == 0) {
				return 1;
			} else {
				return 0;
			}

		} catch (SQLException sqle) {
			System.out.println("\n[ERROR] Database error. " + sqle.getMessage());
			return -1;

		} finally {
			DbUtils.closeQuietly(preparedStatement, connection);
		}
	}

	/**** UPDATE STUDENTS ****/

	public int updateStudent(Student student) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = -1;

		try {
			connection = openConnection();

			String sqlText = "UPDATE Student SET firstname = ?, lastname = ?, streetaddress = ?, postcode = ? , postoffice  = ?  WHERE id = ?";

			preparedStatement = connection.prepareStatement(sqlText);

			preparedStatement.setInt(6, student.getId());
			preparedStatement.setString(1, student.getFirstname());
			preparedStatement.setString(2, student.getLastname());
			preparedStatement.setString(3, student.getStreetaddress());
			preparedStatement.setString(4, student.getPostcode());
			preparedStatement.setString(5, student.getPostoffice());

			result = preparedStatement.executeUpdate();

			if (result == 1) {
				return 0;
			} else {
				return 1;
			}

		} catch (SQLException sqle) {
			System.out.println("\n[ERROR] Database error. " + sqle.getMessage());
			return -1;

		} finally {
			DbUtils.closeQuietly(preparedStatement, connection);
		}

	}
}
