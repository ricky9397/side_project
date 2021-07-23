package bbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.DBClose;
import Database.DBconn;

public class BbsDao {

	private BbsDao() {
	}

	static private BbsDao dao = new BbsDao();

	public static BbsDao getInstance() {
		return dao;
	}

	// 게시글번호 늘어나게 하는 함수
	public int getNext() {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select max(bbsnum) from bbs";
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt("max(bbsnum)");
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

	// 글 작성
	public int write(BbsDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into bbs values(?, ?, ?, sysdate, 0, ?)";
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getBbsNum());
			pstmt.setString(2, dto.getBbsTitle());
			pstmt.setString(3, dto.getId());
			pstmt.setString(4, dto.getBbsContent());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.dbClose(conn);
			DBClose.dbClose(pstmt);
		}
		return 0; // 오류
	}

	// 전체리스트
	public ArrayList<BbsDto> getList() {
		ArrayList<BbsDto> list = new ArrayList<BbsDto>();
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from bbs order by bbsnum desc";

		try {
			conn = DBconn.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int bbsNum = rs.getInt("bbsNum");
				String bbsTitle = rs.getString("bbsTitle");
				String id = rs.getString("id");
				String bbsDate = rs.getString("bbsDate");
				int bbsHit = rs.getInt("bbsHit");
				String bbsContent = rs.getString("bbsContent");

				BbsDto bDto = new BbsDto(bbsNum, bbsTitle, id, bbsDate, bbsHit, bbsContent);
				list.add(bDto);
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
	
	
	// 조회수증가
	public int hitUp(String bbsNum) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update bbs set bbshit=bbshit+1 where bbsnum=?";
		try {
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(bbsNum));
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.dbClose(conn);
			DBClose.dbClose(pstmt);
		}
		return result;
	}
	
	
	// content
	public BbsDto selectByNum(String bbsNum) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from bbs where bbsnum=?";
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(bbsNum));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BbsDto bdto = new BbsDto();
				bdto.setBbsNum(rs.getInt("bbsNum"));
				bdto.setBbsTitle(rs.getString("bbsTitle"));
				bdto.setId(rs.getString("id"));
				bdto.setBbsDate(rs.getString("bbsDate"));
				bdto.setBbsHit(rs.getInt("bbsHit"));
				bdto.setBbsContent(rs.getString("bbsContent"));
				return bdto;
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
	
	// 게시글 수정
	public int update(BbsDto dto) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "update bbs set bbstitle=?, bbscontent=? where bbsnum=?";
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBbsTitle());
			pstmt.setString(2, dto.getBbsContent());
			pstmt.setInt(3, dto.getBbsNum()	);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.dbClose(conn);
			DBClose.dbClose(pstmt);
		}
		return result; // 오류
	}
	
	
	// 게시판글 삭제
	public int delete(String num) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from bbs where bbsnum=?";
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));

			return pstmt.executeUpdate(); // 삭제

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.dbClose(conn);
			DBClose.dbClose(pstmt);
		}
		return 0; // 오류
	}
	

}
