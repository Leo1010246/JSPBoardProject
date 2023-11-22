package com.crud.dao;

import com.crud.common.JDBCUtil;
import com.crud.bean.BoardVO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	private final String BOARD_INSERT = "insert into member_data (name, gender, phone_number, email, address, birthday, photo) values (?,?,?,?,?,?,?)";
	private final String BOARD_UPDATE = "update member_data set name=?, gender=?, phone_number=?, email=?, address=?, birthday=?, photo=? where seq=?";
	private final String BOARD_DELETE = "delete from member_data  where seq=?";
	private final String BOARD_GET = "select * from member_data  where seq=?";
	private final String BOARD_LIST = "select * from member_data order by seq desc";

	public int insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getName());
			stmt.setString(2, vo.getGender());
			stmt.setString(3, vo.getPhone_number());
			stmt.setString(4, vo.getEmail());
			stmt.setString(5, vo.getAddress());
			stmt.setString(6, vo.getBirthday());
			stmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int insertBoardP(String photo) {
		System.out.println("===> JDBC로 insertBoardP() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(7, photo);
			stmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getName());
			stmt.setString(2, vo.getGender());
			stmt.setString(3, vo.getPhone_number());
			stmt.setString(4, vo.getEmail());
			stmt.setString(5, vo.getAddress());
			stmt.setString(6, vo.getBirthday());
			stmt.setString(7, vo.getPhoto());
			stmt.setInt(8, vo.getSeq());

			System.out.println(vo.getName() + "-" + vo.getGender() + "-" + vo.getPhone_number() + "-" + vo.getEmail() + "-" + vo.getAddress() + "-" + vo.getBirthday() + "-" + vo.getPhoto() + "-" + vo.getSeq());
			stmt.executeUpdate();
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}	
	
	public BoardVO getBoard(int seq) {
		BoardVO one = new BoardVO();
		System.out.println("===> JDBC로 getBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, seq);
			rs = stmt.executeQuery();
			if(rs.next()) {
				one.setSeq(rs.getInt("seq"));
				one.setName(rs.getString("name"));
				one.setGender(rs.getString("gender"));
				one.setPhone_number(rs.getString("phone_number"));
				one.setEmail(rs.getString("email"));
				one.setAddress(rs.getString("address"));
				one.setBirthday(rs.getString("Birthday"));
				one.setPhoto(rs.getString("photo"));
				one.setRegdate(rs.getDate("regdate"));
				//one.setCnt(rs.getInt("cnt"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return one;
	}
	
	public List<BoardVO> getBoardList(){
		List<BoardVO> list = new ArrayList<BoardVO>();
		System.out.println("===> JDBC로 getBoardList() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				BoardVO one = new BoardVO();
				one.setSeq(rs.getInt("seq"));
				one.setName(rs.getString("name"));
				one.setGender(rs.getString("gender"));
				one.setPhone_number(rs.getString("phone_number"));
				one.setEmail(rs.getString("email"));
				one.setAddress(rs.getString("address"));
				one.setBirthday(rs.getString("Birthday"));
				one.setPhoto(rs.getString("photo"));
				one.setRegdate(rs.getDate("regdate"));
				//one.setCnt(rs.getInt("cnt"));
				list.add(one);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}
}
