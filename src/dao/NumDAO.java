package dao;


import java.util.ArrayList;
import java.util.List;

import dto.NumDTO;


public interface NumDAO {
	//숫자 넣기
	public void insert(NumDTO dto);
	
	//숫자 넣은거 가져오기
	public ArrayList<NumDTO> select();
	
	public ArrayList<NumDTO> select(int id);
	ArrayList<String> list = new ArrayList<String>();
	List<String> list2 = new ArrayList<String>();
}
