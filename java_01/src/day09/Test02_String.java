package day09;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Test02_String {

	public static void main(String[] args) {

		String msg = "Java programming/23000";
		System.out.println(msg.indexOf("/"));

		String d1 = msg.substring(0, msg.indexOf("/")); // 0부터 슬래쉬있는곳까지 출력
		String d2 = msg.substring(msg.indexOf("/") + 1);
		// 슬래쉬부터 끝까지 뽑는데 +1을 해줘서 슬래쉬 다음부터 끝까지 출력

		System.out.println(d1);
		System.out.println(d2);

		String url = "http://127.0.0.1:8080/web1/list.do";

		System.out.println(url.lastIndexOf("/")); // 라스트 인덱스오브는 뒤에서부터 슬래쉬를 찾는다.
		System.out.println(url.substring(url.lastIndexOf("/") + 1));
		// url.substring(url.indexOf("/"))

		System.out.println(url.contains("web1")); // 문자를 포함하고 있는지 체크한 후 불리언 타입 반환 트루 뽈스

		String data = "2019001_홍길동/90_30/100";
		data = data.replace('_', '/'); // 리플레이스 한 후 데이터에 다시 집어넣어야함.
		//스플릿으로 쪼개기 어려운 경우 리플레이스로 하나로 통일 시켜둔 뒤 스플릿하면 편함!
		String[] sdata = data.split("/");

		System.out.println(Arrays.toString(sdata));
		
		data = "2019001_홍길동/90_30/100";
		System.out.println("-----------------------------------------------------------------------------------");
		StringTokenizer st = new StringTokenizer(data, "/_"); //어떤 기준이든 다 넣어서 쪼갤 수 있다.
		System.out.println(st.countTokens());
		while(st.hasMoreElements()) { //쪼갤 원소가 있는동안 계속돈다.
			System.out.println(st.nextToken()+ " , "); //쪼개진 자원반환 넥스트 토큰
		}
		
	}

}
