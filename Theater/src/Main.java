import model.requetesBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dbc.DatabaseAccessProperties;
import dbc.SQLWarningsExceptions;


public class Main {
	private static final String configurationFile = "DB.properties";

	public static void main(String args[]) {
		try {
			String jdbcDriver, dbUrl, username, password;

			DatabaseAccessProperties dap = new DatabaseAccessProperties(
					configurationFile);
			jdbcDriver = dap.getJdbcDriver();
			dbUrl = dap.getDatabaseUrl();
			username = dap.getUsername();
			password = dap.getPassword();

			// Load the database driver
			Class.forName(jdbcDriver);

			// Get a connection to the database
			Connection conn = DriverManager.getConnection(dbUrl, username,
					password);
			// Print information about connection warnings
			SQLWarningsExceptions.printWarnings(conn);
			
			
			requetesBD.init(conn, "");
			requetesBD.populate(conn, "");
			System.out.println("Initialisation complete.");
			requetesBD.methode_a_1(conn);
			requetesBD.methode_a_2(conn, 101);
			requetesBD.methode_a_3(conn, "Metallica");
			requetesBD.methode_a_4(conn, 101);
			requetesBD.methode_a_5(conn, "Metallica");
			requetesBD.methode_a_6(conn);
			requetesBD.methode_a_7(conn, "14-JAN-09");
			requetesBD.methode_a_9(conn);
			
			conn.close();
		} catch (SQLException se) {

			// Print information about SQL exceptions
			SQLWarningsExceptions.printExceptions(se);

			return;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
			e.printStackTrace();
			return;
		}
	}
}