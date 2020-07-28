package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Product;

public class ProductDao {
	private ProductDao() {}
	private static ProductDao instance=new ProductDao();
	public static ProductDao getInstance() {
		return instance;
	}
	
	public Product selectOne(int code){
		Product product=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from product where code=?";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, code);
			rs=ps.executeQuery();
			if(rs.next()) {
				product=new Product();
				product.setCode(rs.getInt("code"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setPictureurl(rs.getString("pictureurl"));
				product.setDescription(rs.getString("description"));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBConn.close(conn, ps, rs);
		}
		return product;
	}
	
	public List<Product> selectAll(){
		List<Product> list=new ArrayList<Product>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from product order by code desc";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Product product=new Product();
				product.setCode(rs.getInt("code"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setPictureurl(rs.getString("pictureurl"));
				product.setDescription(rs.getString("description"));
				list.add(product);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBConn.close(conn, ps, rs);
		}
		return list;
	}
	
	public boolean insert(Product product) {
		boolean flag=false;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="insert into product(name,price,pictureurl,description) value(?,?,?,?)";
		
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setInt(2, product.getPrice());
			ps.setString(3, product.getPictureurl());
			ps.setString(4, product.getDescription());
			int n=ps.executeUpdate();
			if(n==1) {
				flag=true;
				System.out.println("데이터 입력 성공");
			}else {
				System.out.println("데이터 입력 실패");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			DBConn.close(conn,ps);
		}
		return flag;
		
	}
}
