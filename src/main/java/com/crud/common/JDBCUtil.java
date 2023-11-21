package com.example.jspboardproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	public static Connection getConnection(){  
	    Connection con=null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mariadb://walab.handong.edu:3306/p233_22100699","p233_22100699","Zu1fis");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 오류!");
			throw new RuntimeException(e);
		} catch (SQLException e) {
			System.out.println("DB연결 오류!");
			throw new RuntimeException(e);
		}

		return con;
	}  
	
	public static void main(String ars[]) {
		Connection conn = getConnection();
		if(conn != null)
			System.out.println("DB 연결됨!");
		else
			System.out.println("DB 연결중 오류 !");
	}
}