package com.mfrp.javaclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	String Driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/sathya";
	String username = "root";
	String password = "";
	Connection con;
	public Connection getConnection() {
		// TODO Auto-generated method stub
		try {
			Class.forName(Driver);
			con = DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(con!=null)return con;
		return null;
	}
}
