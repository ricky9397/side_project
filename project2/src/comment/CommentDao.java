package comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import Database.DBClose;
import Database.DBconn;

public class CommentDao {
	
	private CommentDao() {}
	static private CommentDao dao = new CommentDao(); 
	public static CommentDao getInstance() { return dao; }
	
	
	// comment cNum
	public CommentDto getSelectCNum(int cNum) {
		CommentDto comment = new CommentDto();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from comments where cnum=?";
		try {
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				comment.setcNum(rs.getInt("cnum"));
				comment.setcBbsNum(rs.getInt("cbbsnum"));
				comment.setCommentId(rs.getString("commentid"));
				comment.setCommentDate(rs.getString("commentdate"));
				comment.setCommentContent("commentcontent");
				return comment;
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
	
	
	// 댓글 등록
	public int insertComment(CommentDto dto) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into comments values (comment_dix_seq.nextval,?, ?, sysdate,?)";
		try {
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getcBbsNum());
			pstmt.setString(2, dto.getCommentId());
			pstmt.setString(3, dto.getCommentContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 댓글 수정
	public int updateComment(CommentDto dto) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update comments set commentcontent=? where cnum=?";
		try {
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCommentContent());
			pstmt.setInt(2, dto.getcNum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.dbClose(conn);
			DBClose.dbClose(pstmt);
		}
		return result;
	}
	
	// 댓글 리스트
	public ArrayList<CommentDto> getCommentList(int Num){
		ArrayList<CommentDto> list = new ArrayList<CommentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from comments where cbbsnum=? order by cnum desc";
		try {
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new CommentDto(rs.getInt(1), rs.getInt(2), rs.getString(3), 
						rs.getString(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.dbClose(conn);
			DBClose.dbClose(pstmt);
			DBClose.dbClose(rs);
		}
		return list;
	}
	
	public int deleteComment(int num) {
		int result = 0;
		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = "delete from comments where cnum=?";
		try {
			conn = DBconn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.dbClose(pstmt);
		}
		return result;
	}
	
	
}
