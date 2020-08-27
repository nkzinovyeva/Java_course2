package dataAccess;


public class ConnectionParameters {
	
		/* We can set the user name and password here (in SQLite these are optional)
		public static final String username = "";
		public static final String password = "";

		// JDBC driver class name, database location and name, and connection string
		public static final String jdbcDriver = "org.sqlite.JDBC";
		public static final String databaseLocation = "databases/";
		public static final String databaseName = "StudentDB.db";
		public static final String connectionString = "jdbc:sqlite:" + databaseLocation + databaseName;

		// PK violation: The error code in SQLite is 19
		public static final int PK_VIOLATION_ERROR = 19;*/
	
		public static final String username = "";	
		public static final String password = "";	

		// SQLite driver name, database name etc.
		public static final String jdbcDriver = "org.sqlite.JDBC";
		public static final String projectName = "WebAppExercises";
		public static final String databaseFolder = "databases";
	    public static final String databaseName = "StudentDB.db";
	    //public static final String databaseLocation = getDatabaseLocation();
		public static final String databaseLocation = "/Users/karlsoon/eclipse-workspace/qwerty/" + databaseFolder + "/";
		public static final String connectionString = "jdbc:sqlite:" + databaseLocation + databaseName;

		// PK violation: The error code in SQLite is 19
		public static final int PK_VIOLATION_ERROR = 19;

		// This method finds the absolute path to your database file
		/*public static String getDatabaseLocation() {
			String path = System.getProperty("catalina.base");
			 
			path = path.substring(0, path.indexOf(".metadata"));
			path += "/" +projectName + "/" + databaseFolder + "/";
			
			return path;
		}*/
	
}
// End
