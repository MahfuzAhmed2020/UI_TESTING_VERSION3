package com.osa.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"

		String dbUrl = "jdbc:mysql://localhost:3306/osa";

		// Database Username
		String username = "root";

		// Database Password
		String password = "";

		// Query to Execute
		String query = "select *  from Address;";

		// Create Connection to DB
		Connection con = DriverManager.getConnection(dbUrl, username, password);

		// Create Statement Object
		Statement stmt = con.createStatement();

		// Execute the SQL Query. Store results in ResultSet
		ResultSet rs = stmt.executeQuery(query);

		// While Loop to iterate through all data and print results
		while (rs.next()) {
			String address_id = rs.getString(1);
			String street = rs.getString(2);
			String city = rs.getString(3);
			String zip = rs.getString(4);
			System.out.println(address_id + "  " + street + "  " + city + "   " + zip);
		}
		// closing DB Connection
		con.close();
	}
	
	
	public static String[][] getJdbcData(String dbUrl, String username, String password, String query) {
		String[][] value = null;
		// Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
		// String dbUrl = "jdbc:mysql://localhost:3306/osa";
		// Database Username
		// String username = "root";
		// Database Password
		// String password = "";
		// Query to Execute
		// String query = "select * from Address;";
		try {
			// Create Connection to DB
			Connection con;
			con = DriverManager.getConnection(dbUrl, username, password);

			// Create Statement Object
			Statement stmt = con.createStatement();

			// Execute the SQL Query. Store results in ResultSet
			ResultSet rs = stmt.executeQuery(query);
			
			value = new String[500][500];
			// While Loop to iterate through all data and print results
			int count = 0;
			while (rs.next()) {
				String address_id = rs.getString(1);
				String street = rs.getString(2);
				String city = rs.getString(3);
				String zip = rs.getString(4);
				// System.out.println(address_id + " " + street + " " + city + " " + zip );
				// String timeLog = rs.getString(5);
				// System.out.println(street+" "+zip);
				value[count][0] = address_id;
				value[count][1] = street;
				value[count][2] = city;
				value[count][3] = zip;
				count++;
				// System.out.println(street+" "+zip);
				System.out.println(address_id + "  " + street + "  " + city + "   " + zip);
			}

			// closing DB Connection
			con.close();
		} catch (Exception e) {

		}

		return value;
	}
	
	public static void jdbcDataInsert(String dbUrl, String username, String password, String query) {
		// Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
		// String dbUrl = "jdbc:mysql://localhost:3306/osa";
		// Database Username
		// String username = "root";
		// Database Password
		// String password = "";
		// Query to Execute
		// String query = "select * from Address;";
		// Query to Execute write data in database
		// query = "select * from Address;";
		//INSERT INTO Address (street,city,zip) values('587 fulton st','elmhurst', 2);
		// Create Connection to DB
		Connection con;
		try {
			con = DriverManager.getConnection(dbUrl, username, password);
			// Create Statement Object
			Statement stmt = con.createStatement();
			// Write in SQL Query. Store results in ResultSet
			boolean rs = stmt.execute(query);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	


}
