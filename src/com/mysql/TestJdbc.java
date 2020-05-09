package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbc {
	static String dbDriver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/mydb";
	static String user = "root";
	static String password = "ROOT";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement psmt = null;
		try {
			Class.forName(dbDriver);//加载类 DriverManager注册驱动 JDK1.5后可不加此句
			conn = DriverManager.getConnection(url, user, password);
//			stmt = conn.createStatement();
//			int cnt = stmt.executeUpdate("insert into test values(2,'hello',now())");// ����DML�Z��
//			System.out.println(cnt);
//
//			rs = stmt.executeQuery("select * from test");// ����SELECT�Z��
//			while (rs.next()) {
//				System.out.println(rs.getTimestamp(3));
//			}
//			rs.close();
			psmt = conn.prepareStatement("select * from test where id=?");// �Ɏ�����SQL�Z��
			psmt.setInt(1, 2);
			rs = psmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(3));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(psmt);
			close(stmt);
			close(conn);
		}

	}

	public static <T> void close(T t) {
		if ((t instanceof Connection) && t != null) {
			try {
				((Connection) t).close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if ((t instanceof ResultSet) && t != null) {
			try {
				((ResultSet) t).close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if ((t instanceof Statement) && t != null) {
			try {
				((Statement) t).close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

//		if ((t instanceof PreparedStatement) && t != null) {
//			try {
//				((PreparedStatement) t).close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}

}
