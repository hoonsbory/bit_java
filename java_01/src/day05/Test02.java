package day05;

import java.util.Arrays;

public class Test02 {

	public static void main(String[] args) {

		int[] scores = { 77, 99, 100, 88, 91 };
		int[] sc = new int[2 * scores.length];

		System.out.println(Arrays.toString(scores));
		System.out.println(Arrays.toString(sc));

		System.arraycopy(scores, 0, sc, 0, scores.length); 
		//소스포지션 1로 하면 뒤에 배열길이를 -1해줘야함.
		//기능수행을 위해 필요한 정보가 있다면 꼭 넘겨줘야함. 5개의 파라미터를 넘겨줘야함. 
		//주소는 다 오브젝트.dest(데스티네이션)목적지, 소스포지션-소스의 어느위치부터, 
		//destpos 목적지 어느 위치로, 얼마나복사할건지
		System.out.println(Arrays.toString(scores));
		System.out.println(Arrays.toString(sc));
		
		String[] names = {"홍길동","박길동", "신길동" ,"김길동"};
		String[] names2 = new String[2*names.length];
		
		System.arraycopy(names, 0, names2, names2.length-names.length, names.length);
		//					10칸 빼기 5칸이므로 뒷쪽에서 부터 출력. 큰 배열 빼기 작은배열이므로.
		System.out.println(Arrays.toString(names));
		System.out.println(Arrays.toString(names2));
		
	}

}
