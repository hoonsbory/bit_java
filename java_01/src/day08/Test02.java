package day08;

public class Test02 {

	public static void main(String[] args) {

		Student[] students = {

				new Student("신재훈", 20120736, 79, 81, 87), 
				new Student("김길동", 20120731, 10, 70, 89),
				new Student("홍길동", 20120734, 20, 89, 79), 
				new Student("신길동", 20120739, 70, 84, 85),
				new Student("박길동", 20120713, 1000, 81, 80), 
				new Student("개길동", 20120736, 90, 82, 80)

		};
		for (Student data : students) {
			// if(data.getGrade() == 'F')
			data.print();
		}

	}

}

class Student {

	private String name;
	private int num;
	private int kor;
	private int eng;
	private int math;
	private char grade;

	public Student() {
	}

	public Student(String name, int num, int kor, int eng, int math) {
		this.name = name;
		this.num = num;
		// this.kor = kor;
		this.setKor(kor);

		// this.eng = eng;
		this.setEng(eng);

		// this.math = math;
		this.setMath(math);

		// setGradeProcess();

	}

	public Student(String data) {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		// if (!(kor >= 0 && kor <= 100)) {
		// System.out.println(kor + ">>> 점수가 유효하지 않아요");
		// return;

		// }
		if(!aaa(kor)) return;
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		// if (!(eng >= 0 && eng <= 100)) {
		// System.out.println(eng + ">>> 점수가 유효하지 않아요");
		// return;

		// }
		if(!aaa(eng)) return;
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		// if (!(math >= 0 && math <= 100)) {
		// System.out.println(math + ">>> 점수가 유효하지 않아요");
		// return;
		// }
		if(!aaa(math)) return;
		this.math = math;
	}

	public char getGrade() {
		this.setGradeProcess();
		return grade;
	}

	private void setGradeProcess() {
		double avg = (kor + eng + math) / 3;
		this.grade = avg > 90 ? 'A' : (avg >= 80 ? 'B' : (avg >= 70 ? 'C' : (avg >= 60 ? 'D' : 'F')));
	}

	public void print() {

		System.out.printf("이름 : %s 학번: %d  평균 : %d등급 : %c%n", name, num, (kor + eng + math) / 3, this.getGrade());
	}

	private boolean aaa(int b) {
		boolean flag = true;  //플래그에 트루를 주고 이프를 충족하면 false를 주고 아니면 그냥 트루값 리턴.
		if (!(b >= 0 && b <= 100)) {
			System.out.println(b + ">>> 점수가 유효하지 않아요");
			flag = false;
		} 
			return flag;
		
	}
}