package com.javatpoint.project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc {
	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/classicmodels";
		String uname = "root";
		String password = "root";
		String query = "select * from customers;";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException c) {
			c.getStackTrace();
		}

		Connection con = DriverManager.getConnection(url, uname, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);

		rs.next();
		String name = rs.getString(2);
		System.out.println(name);
		st.close();
		con.close();

	}
}
