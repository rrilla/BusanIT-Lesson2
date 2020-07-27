package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConn {
	public static Connection getConn() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext(); // 초기화된 컨텍스트 생성
			Context envContext = (Context) initContext.lookup("java:/comp/env"); // 자바 컴파일 환경
			DataSource ds = (DataSource) envContext.lookup("jdbc/mysqlDB"); // 컨텍스트의 룩업 이름을 가진놈을 가와라
			conn = ds.getConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return conn;
	}

	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (Exception ex) {
		}
	}
	public static void close(Connection conn, PreparedStatement ps) {
		try {
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (Exception ex) {
		}
	}
	
}