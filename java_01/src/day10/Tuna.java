package day10;

public class Tuna extends Animal {

		private String kind = "강아지 종류";
		private String name= "강아지 이름";
		
		
		
		
		
	//	public Tuna() {
		//	super("강아지과"); //애니멀 클래스에 파라미너 하나짜리 생성하는 호출 
			
	//	}
		
		
		public Tuna(String name, String kind) {
			super("강아지과"); //슈퍼에 아무것도 없으면 부모클래스에 가서 찾는다 super.
			this.kind = kind;
			this.name = name;
		}
		public Tuna(String superkind,String kind, String name) {
			super(superkind); //슈퍼에 아무것도 없으면 부모클래스에 가서 찾는다 super.
			//super.kind = superkind;
			this.kind = kind;
			this.name = name;
		}


		public String getKind() {
			return kind;
		}
		public void setKind(String kind) {
			this.kind = kind;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public void dogPrint() {
				System.out.printf("[강아지조아 %s : %s : %s]%n", super.kind, this.kind, this.name);
		}
		public String getSuperKind() {
			return super.kind;
		}
		public void print() {
			super.print();
			System.out.printf("종류 : %s 이름 : %s%n" , name, getKind());
			
		//	super.breath(); 오버라이딩을 했지만 부모클래스의 메소드를 쓰고싶을땐 슈퍼.
		}
}
