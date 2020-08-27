package dataAccess;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtils {
	public static void closeQuietly(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
		closeQuietly(resultSet);
		closeQuietly(preparedStatement, connection);
	}

	public static void closeQuietly(PreparedStatement preparedStatement, Connection connection) {
		closeQuietly(preparedStatement);
		closeQuietly(connection);
	}

	public static void closeQuietly(ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException sqle) {
		}
	}

	public static void closeQuietly(PreparedStatement preparedStatement) {
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		} catch (SQLException sqle) {
		}
	}

	public static void closeQuietly(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException sqle) {
		}
	}
}
