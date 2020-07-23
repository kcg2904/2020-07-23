package dto;

public class NumDTO {
	// 자바에서 DB 테이블이 생성 되면 반드시 DTO를 생성해줘야한다
	private int num1;
	private int num2;
	
	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

}
