package com.nagarro.db;

import java.sql.*;

import com.nagarro.validator.Validation;

public class ConnectDB {
	
	Connection con = null;

	public ConnectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/products", "root", "root");
			
		} catch (Exception e) {

			System.out.println(e);

		}
	}



	public void filterOfAllTable(String preference, String color, String size, String gender) {
		Validation val = new Validation();
		if (!(val.checkPreference(preference) && val.checkGender(gender) && val.checkSize(size))) {
			System.out.println("Invalid Input");
			return;
		}

		String Query = "";
		String wherequery = String.format("where color='%s' and size='%s' and gender='%s'", color, size, gender);
		try {
			 Statement stmt = null;
			 stmt = con.createStatement();
			Query = "Select * from " + "Tshirt " + " " +  wherequery + " order by " + preference;
			ResultSet rs = stmt.executeQuery(Query);
			
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "
						+ rs.getString(4) + " " + rs.getString(5) + " " + rs.getDouble(6) + " " + rs.getDouble(7) + " "
						+ rs.getString(8));
			}
		} catch (Exception e) {
			System.out.println("Invalid Input");

		}
	}

}
