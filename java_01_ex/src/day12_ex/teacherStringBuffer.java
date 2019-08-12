package day12_ex;



public class teacherStringBuffer {
public static void main(String[] args) { 
	String s = " 홍길동 _ 이순신   _김유신     /박철".replace("_", "/");
	String[] n = s.split("/");
for(int i=0; i<n.length; i++) {
		System.out.print(n[i].trim().charAt(0));
		for(int j=0; j<n[i].trim().length()-1;j++) {
			System.out.print("*");
			
		}
		System.out.print(" ");
	}
System.out.println();
mystringbuffer b = new mystringbuffer();
b.print(" 홍길동 / 이순신/김유신 /박철 ","/, ");
}
	
}
