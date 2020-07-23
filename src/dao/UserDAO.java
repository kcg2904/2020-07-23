package dao;

import java.util.ArrayList;

import dto.UserDTO;

public interface UserDAO {
// 데이터 값 넣기
	public void insert(UserDTO dto);
	//전체검색
	public ArrayList<UserDTO> select();
	// 조건 검색
	public UserDTO select(String id);
	// 업데이트
	public void update(UserDTO dto);
}
