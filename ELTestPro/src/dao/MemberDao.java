package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import vo.Member;

public class MemberDao {
	private MemberDao() {
	}
	private static MemberDao instance=new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}
	
	private Connection getConn() {
		Connection conn=null;
		try {
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/mysql_db");
		conn = ds.getConnection();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	}
	
	public List<Member> selectAll(){
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from member";
		List<Member> list = new ArrayList<Member>();
		
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Member member = new Member();
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				list.add(member);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			}catch(Exception ex) {}
		}
		return list;
	}
}
