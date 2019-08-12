package day10;

public class D_caPhone  extends CellPhone{
		
	public D_caPhone (String model) {
		this.model = model; //생략된 슈퍼가 부모클래스에 있는 모델변수에 값을 넣어버림
	}
}
