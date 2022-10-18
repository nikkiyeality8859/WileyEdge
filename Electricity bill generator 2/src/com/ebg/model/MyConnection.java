package com.ebg.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {

	public static Connection buildConnection() throws Exception {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wileyjdbc","root", "Nikita@1234");
		 return con;
		
	}

}
