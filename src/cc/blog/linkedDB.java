package cc.blog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class linkedDB {
	static Connection getConnection() throws SQLException {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}

		String dbUrl = "R:\\sts-bundle\\workspace\\SketchBlog\\usingDB.db";
		Connection conn = DriverManager.getConnection("jdbc:sqlite:" + dbUrl);
		return conn;
	}

}
