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
}
