package dao;

import java.sql.*;
import java.util.ArrayList;

import db.DB;
import dto.UserDTO;

public class UserDAOImpl implements UserDAO {

	@Override
	public void insert(UserDTO dto) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DB.condb();
			String sql = "INSERT INTO user (id, name) VALUES(?, ?)";
			pstmt = conn.prepareStatement(sql);
			// 4. 데이터 binding
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			
			int count = pstmt.executeUpdate();
			if (count == 0) {
				System.out.println("데이터 입력 실패");
			} else {
				System.out.println("데이터 입력 성공");
			}

		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	@Override
	public ArrayList<UserDTO> select() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 전달 변수(dto 담을 그릇)
		ArrayList<UserDTO> list = new ArrayList<UserDTO>();
		try {
			conn = DB.condb();
			String sql = "SELECT * FROM user";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserDTO dto = new UserDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setJumsu(rs.getInt("jumsu"));
				list.add(dto);
				
//				System.out.print(rs.getString("num") + ". ");
//				System.out.print(rs.getString("name") + " ");
//				System.out.println(rs.getString("price"));
			}

		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if( rs != null && !rs.isClosed()){
                    rs.close();
                }
				if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public UserDTO select(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 전달 변수(dto 담을 그릇)
		UserDTO dto = null;
		try {
			conn = DB.condb();
			String sql = "SELECT * FROM user WHERE id= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dto = new UserDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setJumsu(rs.getInt("jumsu"));
			}else {
				System.out.println("사용자가 없다.");
			}

		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if( rs != null && !rs.isClosed()){
                    rs.close();
                }
				if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}


	@Override
	public void update(UserDTO dto) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DB.condb();
			String sql = "update user set jumsu=? WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			// 4. 데이터 binding
			pstmt.setInt(1, dto.getJumsu());
			pstmt.setString(2, dto.getId());
			
			int count = pstmt.executeUpdate();
			if (count == 0) {
				System.out.println("데이터 입력 실패");
			} else {
				System.out.println("데이터 입력 성공");
			}

		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
