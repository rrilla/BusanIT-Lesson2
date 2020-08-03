package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.Member;

public class MemberDao {
	private MemberDao() {}
	private static MemberDao instance = new MemberDao();
	
	public static MemberDao getInstance() {
		return instance;
	}
	
	public boolean insert(Member member){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="insert into b_member(id, pw, name) values(?, ?, ?)";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, member.getId());
			ps.setString(2, member.getPw());
			ps.setString(3, member.getName());
			int n=ps.executeUpdate();
			if(n==1) {
				flag=true;
				System.out.println("회원 등록 성공");
			}else {
				System.out.println("회원 등록 실패");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBConn.close(conn, ps);
		}
		return flag;
	}
	
	public Member selectOne(int no){
		Member member=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from b_member where id=?";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			rs=ps.executeQuery();
			if(rs.next()) {
				member=new Member();
				member.setId(rs.getNString("id"));
				member.setPw(rs.getNString("pw"));
				member.setName(rs.getNString("name"));
				member.setReg_date(rs.getDate("reg_date"));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBConn.close(conn, ps, rs);
		}
		return member;
	}
	
	public boolean overappendId(String id) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from b_member where id=?";
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				flag = true;
				System.out.println("아이디 겹친다");
			}else {
				System.out.println("아이디 합격");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(conn, ps);
		}
		return flag;
	}
	
	public int login(String id, String pw) {
		int n = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select pw from b_member where id=?";
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				if(pw.equals(rs.getString(1))) { //rs.getString(1) = select결과의 1번째 결과 칼럼
					n = 1;
					System.out.println("로그인 성공!!");
				}else {
					n = 0;
					System.out.println("비번 다름");
				}
			}else {
				System.out.println("아이디 없음");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(conn, ps, rs);
		}
		return n;
	}
	
	public boolean update(Member member) {
		boolean flag=false;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update b_member set pw=?, name=? where id=?";
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getPw());
			ps.setString(2, member.getName());
			ps.setString(3, member.getId());
			int n = ps.executeUpdate();
			if(n == 1) {
				flag = true;
				System.out.println("update O");
			}else {
				System.out.println("update X");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(conn, ps);
		}
		return flag;
	}
	
	public boolean delete(String id) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from b_member where id=?";
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			int n = ps.executeUpdate();
			if(n == 1) {
				flag = true;
				System.out.println("delete O");
			}else {
				System.out.println("delete X");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(conn, ps);
		}
		return flag;
	}
	
}
