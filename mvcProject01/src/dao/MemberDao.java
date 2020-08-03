package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Member;

public class MemberDao {
	private MemberDao() {}
	private static MemberDao instance=new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}
	
	public List<Member> selectAll(){
		List<Member>list=new ArrayList<Member>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from member";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Member member=new Member();
				member.setNo(rs.getInt("no"));
				member.setId(rs.getNString("id"));
				member.setPw(rs.getNString("pw"));
				member.setName(rs.getNString("name"));
				member.setReg_data(rs.getDate("reg_date"));
				list.add(member);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBConn.close(conn, ps, rs);
		}
		return list;
	}
	
	public Member selectOne(String id){
		Member member=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from member where id=?";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				member=new Member();
				member.setNo(rs.getInt("no"));
				member.setId(rs.getNString("id"));
				member.setPw(rs.getNString("pw"));
				member.setName(rs.getNString("name"));
				member.setReg_data(rs.getDate("reg_date"));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBConn.close(conn, ps, rs);
		}
		return member;
	}
	
	public boolean insert(Member member){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="insert into member(no,id,pw,name) values(member_seq.nextval,?,?,?)";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, member.getId());
			ps.setString(2, member.getPw());
			ps.setString(3, member.getName());
			int n=ps.executeUpdate();
			if(n==1) {
				flag=true;
				System.out.println("insert O");
			}else {
				System.out.println("insert X");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBConn.close(conn, ps);
		}
		return flag;
	}
	
	public boolean update(Member member){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="update member set pw=?,name=? where no=?";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setNString(1, member.getId());
			ps.setNString(2, member.getPw());
			ps.setInt(3, member.getNo());
			int n=ps.executeUpdate();
			if(n==1) {
				flag=true;
				System.out.println("update O");
			}else {
				System.out.println("update X");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBConn.close(conn, ps);
		}
		return flag;
	}
	
	public boolean delete(String id){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="delete from member where id=?";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			int n=ps.executeUpdate();
			if(n==1) {
				flag=true;
				System.out.println("delete O");
			}else {
				System.out.println("delete X");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBConn.close(conn, ps);
		}
		return flag;
	}

}
