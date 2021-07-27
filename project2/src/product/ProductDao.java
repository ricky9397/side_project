package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.DBClose;
import Database.DBconn;
import bbs.BbsDto;
import comment.CommentDto;
import member.MemberDto;

public class ProductDao {
	
	private ProductDao() {}
	static private ProductDao dao = new ProductDao();
	public static ProductDao getInstance() {
		return dao;
	}
	
	public int getNext() {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select max(icode) from product";
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt("max(icode)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.dbClose(conn);
			DBClose.dbClose(pstmt);
			DBClose.dbClose(rs);
		}
		return result;
	}
	
	// 상품 등록
	public int productInsert(ProductDto dto) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into product values (?, ?, ?, ?)";
		try {
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getiCode());
			pstmt.setString(2, dto.getiName());
			pstmt.setInt(3, dto.getiPrice());
			pstmt.setInt(4, dto.getCount());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.dbClose(conn);
			DBClose.dbClose(pstmt);
		}
		return result;
	}
	
	
	// 상품 리스트
	public ArrayList<ProductDto> getProductList(){
		ArrayList<ProductDto> list = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from product";
		
		try {
			conn = DBconn.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			list = new ArrayList<>();
			
			while(rs.next()) {
				list.add(new ProductDto(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getInt(3),
						rs.getInt(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.dbClose(conn);
			DBClose.dbClose(stmt);
			DBClose.dbClose(rs);
		}
		return list;
	}
	
	
	// 상품클릭 후 상세보기 
	public ProductDto selectIcode(int iCode) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from product where icode=?";
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, iCode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductDto dto = new ProductDto();
				dto.setiCode(rs.getInt("iCode"));
				dto.setiName(rs.getString("iName"));
				dto.setiPrice(rs.getInt("iPrice"));
				dto.setCount(rs.getInt("count"));
				return dto;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.dbClose(conn);
			DBClose.dbClose(pstmt);
			DBClose.dbClose(rs);
		}
		return null;
	}
	
	// 장바구니 리스트
//	public ArrayList<ProductDto> getProductList(int Num){
//		ArrayList<ProductDto> list = new ArrayList<ProductDto>();
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String sql = "select * from product where icode=?";
//		try {
//			conn = DBconn.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, Num);
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				list.add(new ProductDto(rs.getInt(1), 
//						rs.getString(2), rs.getInt(3), 
//						rs.getInt(4)));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBClose.dbClose(conn);
//			DBClose.dbClose(pstmt);
//			DBClose.dbClose(rs);
//		}
//		return list;
//	}
	
	
}