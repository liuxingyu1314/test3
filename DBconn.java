package com.util;
import java.sql.*;

public class DBconn {
	//static String url = "jdbc:mysql://172.16.10.200:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	//static String url = "jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static String url = "jdbc:mysql://10.239.113.92:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static String username = "root";
	static String password = "123456";
	static Connection conn = null;
	static ResultSet rs = null;
	static PreparedStatement ps =null;
	public static void init(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("init [SQL驱动程序初始化成功！]");
		} catch (Exception e) {
			System.out.println("init [SQL驱动程序初始化失败！]");
			e.printStackTrace();
		}
	}
	public static int addUpdDel(String sql){
		int i = 0;
		try {
			PreparedStatement ps =  conn.prepareStatement(sql);
			i =  ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql数据库增删改异常");
			e.printStackTrace();
		}

		return i;
	}
	public static ResultSet selectSql(String sql){
		try {
			ps =  conn.prepareStatement(sql);
			rs =  ps.executeQuery(sql);

		} catch (SQLException e) {
			System.out.println("sql数据库查询异常");
			e.printStackTrace();
		}
		return rs;
	}
	public static void closeConn(){
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("sql数据库关闭异常");
			e.printStackTrace();
		}
	}
	public static void main(String args[]){
		DBconn.init();
	}

}

