package game;

import java.util.Scanner;

import dao.UserDAOImpl;
import dto.UserDTO;

public class MainClass {
	public static void main(String[] args) {
		System.out.println("DB GAME");
		System.out.println("아이디가 있으면 아이디 입력\n없으면 회원가입");
		System.out.print("입력 > ");
		Scanner sc = new Scanner(System.in);
		String id = sc.next(); // id 입력받기
		System.out.println("당신이 입력한 ID : " + id);
		UserDAOImpl ud = new UserDAOImpl();
		UserDTO dto = ud.select(id);
		if (dto == null) {
			// dto가 null 이기 때문에 new 로 공간을 만들어야함
			dto = new UserDTO();
			System.out.println("환영합니다.");
			System.out.print("이름을 입력하세요 > ");
			String name = sc.next();
			// id와 이름을 dto에 셋팅
			dto.setId(id);
			dto.setName(name);
			// db에 값 넣음
			ud.insert(dto);
//		} else {
//			System.out.println("데이터가 있음");
//			System.out.println(dto.getId()+ "," + dto.getName()+","+dto.getJumsu());
//		}
		}
		System.out.println("당신의 정보입니다.");
		System.out.println("아이디 : " + dto.getId());
		System.out.println("이름 : " + dto.getName());
		System.out.println("점수 : " + dto.getJumsu());
	}
}