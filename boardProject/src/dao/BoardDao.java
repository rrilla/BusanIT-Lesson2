package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Board;

public class BoardDao {
	private BoardDao() {}
	private static BoardDao bDao = new BoardDao();
	public static BoardDao getInstance() {
		return bDao;
	}
	
	public List<Board> selectAll() {
		String sql = "select * from m_board order by bno desc";
		List<Board> list = new ArrayList<Board>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setReadcount(rs.getInt("readcount"));
				board.setWritedate(rs.getTimestamp("writedate"));
				board.setImage_name(rs.getString("image_name"));
				board.setReplycount(rs.getInt("replycount"));
				list.add(board);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public boolean insertBoard(Board board) {
		boolean flag = false;
		String sql = "insert into m_board(bno, title, content, writer, image_name) values(bno_seq.nextval, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConn.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  board.getTitle());
			pstmt.setString(2,  board.getContent());
			pstmt.setString(3,  board.getWriter());
			pstmt.setString(4,  board.getImage_name());
			int n = pstmt.executeUpdate();
			if(n == 1) {
				flag = true;
				System.out.println("게시글이 db에 저장o");
			}else {
				System.out.println("게시글 db 저장x");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
		return flag;
	}
	
	public Board selectOne(int bno) {
		String sql = "select * from m_board where bno = ?";
		Board board = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,  bno);
			rs = ps.executeQuery();
			if(rs.next()) {
				board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWritedate(rs.getTimestamp("writedate"));
				board.setImage_name(rs.getString("image_name"));
				board.setReadcount(rs.getInt("readcount"));
				board.setReplycount(rs.getInt("replyCount"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(conn, ps, rs);
		}
		return board;
	}
	
	public boolean updateReadCount(int bno) {
		boolean flag = false;
		String sql = "update m_board set readcount = readcount+1 where bno=?";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int n = ps.executeUpdate();
			if(n == 1) {
				flag = true;
				System.out.println("조회 업뎃 o");
			}else {
				System.out.println("조회 업뎃 x");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(conn, ps);
		}
		return flag;
	}
	
	public boolean updateBoard(Board board) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "update m_board set title=?, content=?, image_name=? where num=?";
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, board.getTitle());
			ps.setString(2,  board.getContent());
			ps.setString(3, board.getImage_name());
			ps.setInt(4, board.getBno());
			int n = ps.executeUpdate();
			if(n == 1) {
				flag = true;
				System.out.println("글 업뎃 o");
			}else { 
				System.out.println("글 업뎃 x");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(conn, ps);
		}
		return flag;
	}

	public boolean deleteBoard(int bno) {
		String sql = "delete from m_board where bno=?";
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			int n = ps.executeUpdate();
			if(n == 1) {
				flag = true;
				System.out.println("글 삭제 o");
			}else {
				System.out.println("글 삭제 x");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBConn.close(conn, ps);
		}
		return flag;
	}
	
}
