package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.HashMap;

/**
 *
 * @author Valentin
 */
public class requetesBD {

	/**
	 * Crée ou recrée les tables dans la base
	 *
	 * @param conn
	 *            connexion à la base de données
	 * @param SQL
	 *            requêtes SQL d'insert au format texte
	 * @throws SQLException
	 *             en cas d'erreur d'accès à la base de données
	 */
	public static void init(Connection conn, String SQL) throws SQLException {
		// TODO: (re-)créer les tables de la bdd
		Statement stmt = conn.createStatement();

		stmt.close();
	}

	/**
	 * Remplit la base avec des informations
	 *
	 * @param conn
	 *            connexion à la base de données
	 * @param SQL
	 *            requêtes SQL d'insert au format texte
	 * @throws SQLException
	 *             en cas d'erreur d'accès à la base de données
	 */
	public static void populate(Connection conn, String SQL) throws SQLException {
		// TODO: remplir la bdd avec les n-uplets (à partir d'un fichier ou
		// autre)
		Statement stmt = conn.createStatement();
		String[] queries = { "insert into spectacle values ('101', 'Cats')", "insert into spectacle values ('102', 'Metallica')", "insert into spectacle values ('103', 'Manu Chao')",
				"insert into spectacle values ('104', 'Cirque du Soleil')", "insert into representation values ('101', '06-NOV-08')", "insert into representation values ('102', '20-DEC-08')",
				"insert into representation values ('104', '14-JAN-09')", "insert into representation values ('104', '20-FEB-09')", "insert into representation values ('104', '21-FEB-09')",
				"insert into representation values ('104', '22-FEB-09')" };
		for (String q : queries) {
			stmt.addBatch(q);
			System.out.println(q);
		}
		System.out.println("nyon");
		stmt.executeBatch();

		System.out.println("nyan");
		stmt.close();
	}

	/**
	 * Afficher toutes les informations sur tous les spectacles.
	 *
	 * @param conn
	 *            connexion à la base de données
	 * @throws SQLException
	 *             en cas d'erreur d'accès à la base de données
	 */
	public static void methode_a_1(Connection conn) throws SQLException {
		// Get a statement from the connection
		Statement stmt = conn.createStatement();
		String query = "SELECT * FROM Spectacle";
		// Execute the query
		ResultSet rs = stmt.executeQuery(query);
		// Displays the results
		System.out.println("Spectacles :");
		while (rs.next()) {
			System.out.println("N°" + rs.getInt("numeroSpectacle") + " : " + rs.getString("nomSpectacle"));
		}
		// Close the result set and the statement
		rs.close();
		stmt.close();
	}

	/**
	 * Afficher le nom du ou des spectacle(s) de numéro numS
	 *
	 * @param conn
	 *            connexion à la base de données
	 * @param numS
	 *            numéro du spectacle
	 * @throws SQLException
	 *             en cas d'erreur d'accès à la base de données
	 */
	public static void methode_a_2(Connection conn, int numS) throws SQLException {
		// Get a statement from the connection
		Statement stmt = conn.createStatement();
		String query = "SELECT nomSpectacle FROM Spectacle WHERE numeroSpectacle = '" + numS + "'";
		// Execute the query
		ResultSet rs = stmt.executeQuery(query);
		if (rs.getFetchSize() > 0) {
			// Displays the results
			System.out.println("Spectacle(s) correspondant au n°" + numS + " :");
			while (rs.next()) {
				System.out.println(rs.getString("nomSpectacle"));
			}
		} else {
			// Displays an error message (0 spectacle)
			System.out.println("Aucun spectacle n'a pour numéro '" + numS + "'.");
		}
		// Close the result set and the statement
		rs.close();
		stmt.close();
	}

	/**
	 * Afficher le numéro du ou des spectacle(s) de nom nomS
	 *
	 * @param conn
	 *            connexion à la base de données
	 * @param nomS
	 *            nom du spectacle
	 * @throws SQLException
	 *             en cas d'erreur d'accès à la base de données
	 */
	public static void methode_a_3(Connection conn, String nomS) throws SQLException {
		// Get a statement from the connection
		Statement stmt = conn.createStatement();
		String query = "SELECT numeroSpectacle FROM Spectacle WHERE nomSpectacle = '" + nomS + "'";
		// Execute the query
		ResultSet rs = stmt.executeQuery(query);
		if (rs.getFetchSize() > 0) {
			// Displays the results
			System.out.println("Spectacle(s) ayant pour nom " + nomS + " :");
			while (rs.next()) {
				System.out.println(rs.getInt("numeroSpectacle"));
			}
		} else {
			// Displays an error message (0 spectacle)
			System.out.println("Aucun spectacle n'a pour nom '" + nomS + "'.");
		}
		// Close the result set and the statement
		rs.close();
		stmt.close();
	}

	/**
	 * Afficher le ou les représentations du spectacle de numéro numS
	 *
	 * @param conn
	 *            connexion à la base de données
	 * @param numS
	 *            numéro du spectacle
	 * @throws SQLException
	 *             en cas d'erreur d'accès à la base de données
	 */
	public static void methode_a_4(Connection conn, int numS) throws SQLException {
		// Get a statement from the connection
		Statement stmt = conn.createStatement();
		String query1 = "SELECT nomSpectacle FROM Spectacle WHERE numeroSpectacle = '" + numS + "'";
		String query2 = "SELECT * FROM Représentation where numeroSpectacle = '" + numS + "'";
		// Execute the first query
		ResultSet rs1 = stmt.executeQuery(query1);
		System.out.println(rs1.getFetchSize());
		// Gets the result of the first query
		if (rs1.next()) {
			String nomS = rs1.getString("nomSpectacle");
			// Close the first result set
			rs1.close();
			// Execute the second query
			ResultSet rs2 = stmt.executeQuery(query2);
			if (rs2.getFetchSize() > 0) {
				System.out.println("2");
				// Displays the result of the first query
				System.out.println("Le spectacle(s) " + nomS + ", n°" + numS + " a les représentations suivantes :");
				// Displays the result of the second query
				while (rs2.next()) {
					System.out.println("  - " + rs2.getDate("dateRepresentation"));
				}
			} else {
				// Displays an error message (0 representation)
				System.out.println("Le spectacle '" + nomS + "', n°" + numS + " n'a aucune représentation.");
			}
			rs2.close();
		} else {
			// Displays an error message (0 spectacle)
			System.out.println("Aucun spectacle n'a pour numéro '" + numS + "'.");
		}

		// Close the statement
		stmt.close();
	}

	/**
	 * Afficher les représentations du ou des spectacle(s) ayant pour nom nomS
	 *
	 * @param conn
	 *            connexion à la base de données
	 * @param nomS
	 *            nom du spectacle
	 * @throws SQLException
	 *             en cas d'erreur d'accès à la base de données
	 */
	public static void methode_a_5(Connection conn, String nomS) throws SQLException {
		// Get a statement from the connection
		Statement stmt = conn.createStatement();
		String query = "SELECT numeroSpectacle FROM Spectacle WHERE nomSpectacle = '" + nomS + "'";
		// Execute the query
		ResultSet rs = stmt.executeQuery(query);

		if (rs.getFetchSize() > 0) {
			// Displays the results
			while (rs.next()) {
				Integer numS = rs.getInt("numeroSpectacle");
				// Calls the a_4 method to display the representations
				methode_a_4(conn, numS);
			}
		} else {
			// Displays an error message (0 spectacle)
			System.out.println("Aucun spectacle n'a pour nom '" + nomS + "'.");
		}
		// Close the result set and the statement
		rs.close();
		stmt.close();
	}

	/**
	 * Afficher toutes les représentations de tous les spectacles
	 *
	 * @param conn
	 *            connexion à la base de données
	 * @throws SQLException
	 *             en cas d'erreur d'accès à la base de données
	 */
	public static void methode_a_6(Connection conn) throws SQLException {
		// Get a statement from the connection
		Statement stmt = conn.createStatement();
		String query1 = "SELECT * FROM Spectacle";
		// Execute the first query
		ResultSet rs1 = stmt.executeQuery(query1);
		// Gets the result of the first query
		while (rs1.next()) {
			String nomS = rs1.getString("nomSpectacle");
			String numS = rs1.getString("numeroSpectacle");
			String query2 = "SELECT * FROM Représentation where numeroSpectacle = '" + numS + "'";
			// Execute the second query
			ResultSet rs2 = stmt.executeQuery(query2);
			if (rs2.getFetchSize() > 0) {
				// Displays the result of the first query
				System.out.println("Le spectacle '" + nomS + "', n°" + numS + " a les représentations suivantes :");
				// Displays the result of the second query
				while (rs2.next()) {
					System.out.println("  - " + rs2.getDate("dateRepresentation"));
				}
			} else {
				// Displays an error message (0 representation)
				System.out.println("Le spectacle '" + nomS + "', n°" + numS + " n'a aucune représentation.");
			}
			// Close the second result set
			rs2.close();
		}

		// Close the first result set and the statement
		rs1.close();
		stmt.close();
	}

	/**
	 * Afficher les spectacles représentés à une date donnée
	 *
	 * @param conn
	 *            connexion à la base de données
	 * @param date
	 *            date dont l'on veut connaître les représentations
	 * @throws SQLException
	 *             en cas d'erreur d'accès à la base de données
	 */
	public static void methode_a_7(Connection conn, String date) throws SQLException {
		// Get a statement from the connection
		Statement stmt = conn.createStatement();
		String query = "SELECT S.* FROM Spectacle S, Representation R WHERE R.numeroSpectacle = S.numeroSpectacle AND R.dateRepresentation = '" + date + "'";
		// Execute the query
		ResultSet rs = stmt.executeQuery(query);
		if (rs.next()) {
			System.out.println("Spectacle ayant une représentation à la date '" + date + "' :");
			// Displays the results
			do {
				Integer numS = rs.getInt("numeroSpectacle");
				// Calls the a_4 method to display the representations
				methode_a_4(conn, numS);
			} while (rs.next());
		} else {
			// Displays an error message (0 representation)
			System.out.println("Aucun spectacle n'a de représentation à la date '" + date + "'.");
		}
		// Close the result set and the statement
		rs.close();
		stmt.close();
	}

	/* CONTENU DU SCHEMA */

	/**
	 * Afficher la liste de tous les n-uplets d'une table
	 *
	 * @param conn
	 *            connexion à la base de données
	 * @param nomTable
	 *            le nom de la table que l'on veut lister
	 * @throws SQLException
	 *             en cas d'erreur d'accès à la base de données
	 */
	public static void methode_a_8(Connection conn, String nomTable) throws SQLException {
		// Get a statement from the connection
		Statement stmt = conn.createStatement();
		String query = "SELECT * FROM " + nomTable + "";
		// Execute the query
		ResultSet rs = stmt.executeQuery(query);
		if (rs.getFetchSize() > 0) {
			System.out.println("La table '" + nomTable + "' contient :");
			// Get the metada before displaying the results
			ResultSetMetaData mD = rs.getMetaData();
			while (rs.next()) {
				// Starts the line
				System.out.print(rs.getRow() + " - ");
				for (int i = 1; i <= mD.getColumnCount(); ++i) {
					String name = mD.getColumnName(i);
					String value;
					switch (mD.getColumnType(i)) {
					case Types.VARCHAR:
					case Types.CHAR:
						value = rs.getString(i);
						break;
					case Types.INTEGER:
						value = Integer.toString(rs.getInt(i));
						break;
					case Types.FLOAT:
						value = Float.toString(rs.getFloat(i));
						break;
					case Types.DATE:
						value = rs.getDate(i).toString();
						break;
					default:
						value = rs.getBytes(i).toString();
					}
					// Writes the value of the current column
					System.out.print(name + "= '" + value + "' ");
				}
				// Closes the line
				System.out.println();
			}
		} else {
			// Displays an error message (0 representation)
			System.out.println("La table '" + nomTable + "' est vide.");
		}

		// Close the result set and the statement
		rs.close();
		stmt.close();
	}

	/**
	 * Afficher la liste de tous les n-uplets de toutes les tables
	 *
	 * @param conn
	 *            connexion à la base de données
	 * @throws SQLException
	 *             en cas d'erreur d'accès à la base de données
	 */
	public static void methode_a_9(Connection conn) throws SQLException {
		methode_a_8(conn, "categorie");
		System.out.println();
		System.out.println();
		methode_a_8(conn, "zone");
		System.out.println();
		System.out.println();
		methode_a_8(conn, "place");
		System.out.println();
		System.out.println();
		methode_a_8(conn, "spectacle");
		System.out.println();
		System.out.println();
		methode_a_8(conn, "representation");
		System.out.println();
		System.out.println();
		methode_a_8(conn, "dossier");
		System.out.println();
		System.out.println();
		methode_a_8(conn, "billet");
	}

	/**
	 * Affiche les informations concernant une zone
	 *
	 * @param
	 * 
	 * @throws SQLException
	 *             en cas d'erreur d'accès à la base de données
	 */
	public static void methode_b(Connection conn) throws SQLException {
	}

	/**
	 * Affiche les numéros de zone associées à la catégorie fournie
	 *
	 * @param nomCat
	 * 
	 * @throws SQLException
	 *             en cas d'erreur d'accès à la base de données
	 */
	public static void methode_c(Connection conn, String nomCat) throws SQLException {
	}

	/**
	 * Affiche le prix et l'ensemble des places des zones d'une catégorie
	 *
	 * @param nomCat
	 * 
	 * @throws SQLException
	 *             en cas d'erreur d'accès à la base de données
	 */
	public static void methode_d(Connection conn, String nomCat) throws SQLException {
	}

	/**
	 * Affiche la catégorie et l'ensemble des places d'une zone
	 *
	 * @param numZ
	 * 
	 * @throws SQLException
	 *             en cas d'erreur d'accès à la base de données
	 */
	public static void methode_e(Connection conn, int numZ) throws SQLException {
	}

	/**
	 * Affiche la place achetée, pour un dossier donné
	 *
	 * @param numD
	 * 
	 * @throws SQLException
	 *             en cas d'erreur d'accès à la base de données
	 */
	public static void methode_f(Connection conn, int numD) throws SQLException {
	}

	/**
	 * Affiche toutes les places achetées, pour un dossier donné
	 *
	 * @param numD
	 * 
	 * @throws SQLException
	 *             en cas d'erreur d'accès à la base de données
	 */
	public static void methode_g(Connection conn, int numD) throws SQLException {
	}

	/**
	 * Affiche le total du prix d'un dossier
	 *
	 * @param numD
	 * 
	 * @throws SQLException
	 *             en cas d'erreur d'accès à la base de données
	 */
	public static void methode_h(Connection conn, int numD) throws SQLException {
	}

	/**
	 * Affiche les places déjà vendues, pour une représentation
	 *
	 * @param numS
	 * @param date
	 * 
	 * @throws SQLException
	 *             en cas d'erreur d'accès à la base de données
	 */
	public static void methode_i(Connection conn, int numS, String date) throws SQLException {
	}

	/**
	 * Affiche les places encore disponibles pour une représentation
	 *
	 * @param numS
	 * @param date
	 * 
	 * @throws SQLException
	 *             en cas d'erreur d'accès à la base de données
	 */
	public static void methode_j(Connection conn, int numS, String date) throws SQLException {
	}

	/**
	 * Effectue la vente d'une place
	 *
	 * @param numS
	 * @param date
	 * @param numRang
	 * @param ordrePlace
	 * 
	 * @throws SQLException
	 *             en cas d'erreur d'accès à la base de données
	 */
	public static void methode_k(Connection conn, int numS, String date, int numRang, int ordrePlace) throws SQLException {
	}

	/**
	 * Effectue une vente quelconque
	 *
	 * @param representation
	 *            map d'une représentation (numeroSpectacle,Date)
	 * @param place
	 *            map d'une place (numRang,ordrePlace)
	 * @throws SQLException
	 *             en cas d'erreur d'accès à la base de données
	 */
	public static void methode_l(Connection conn, HashMap<Integer, String> representation, HashMap<Integer, Integer> place) throws SQLException {
		// TODO: gérer les HashMaps ou trouver un autre moyen d'effectuer une
		// vente complexe
	}

	/**
	 * Annule la vente d'une place
	 *
	 * @param numS
	 * @param date
	 * @param numRang
	 * @param ordrePlace
	 * 
	 * @throws SQLException
	 *             en cas d'erreur d'accès à la base de données
	 */
	public static void methode_m(Connection conn, int numS, String date, int numRang, int ordrePlace) throws SQLException {
	}

	/**
	 * Annule une vente
	 *
	 * @param numD
	 * 
	 * @throws SQLException
	 *             en cas d'erreur d'accès à la base de données
	 */
	public static void methode_n(Connection conn, int numD) throws SQLException {
	}
}