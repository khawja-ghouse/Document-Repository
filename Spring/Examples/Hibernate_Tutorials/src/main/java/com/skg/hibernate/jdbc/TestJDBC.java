package com.skg.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {

		String jdbcurl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "root";
		String password = "root";
		try {
			System.out.println("Connecting to JDBC " + jdbcurl);

			Connection connection = DriverManager.getConnection(jdbcurl, user, password);

			System.out.println("Connection Success !!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
