package util;

public class MyUtil { // 메소드 오버로딩의 예  >> Arrays.toString 매개변수가 다 다른 메소드 오버로딩.
	//모든 기본형과 오브젝트 배열을 다 처리하는 메소드로 오버로딩. (이름은 하난데 다양한 기능을 처리할 수 있는 메소드)

	public static long add(int a, int b) { // 패키지가 다르기때문에 퍼블릭을 뺴면 에러가남.

		return a + b;

	}

	public static double add(double a, double b, double c) { // 패키지가 다르기때문에 퍼블릭을 뺴면 에러가남.
		// 메소드 오버로딩
		// 메소드 이름이 같아도 매개변수의 타입이나 갯수가 다르면 사용가능. 구분이 가능하기때문. 이게 바로 메소드 오버로딩
		// add함수에 두가지 기능을 넣었다고 보면 될 듯.
		// 리턴타입은 오버로딩 조건에 해당안됨. "매개변수의 타입과 갯수가 달라야함"
		return a + b + c;
	}

	public static long add(int a, int b, int c) { // 패키지가 다르기때문에 퍼블릭을 뺴면 에러가남.

		return a + b + c;

	}

	// 가변인자 쓰는법.
	public static int add(int d, int... nums) {// ...은 데이터가 몇개 들어올지 모를떄 .(가변형) []처리됨
		// nums라는 가변형 배열에 가변인자가 들어감.
		// 가변인자는 매개변수중 가장 마지막 위치에 와야함. 가변인자가 몇개 들어올지 모르기때문.
		// 가변인자랑 인트타입 d를 같이 사용하면 함수에서 출력하려했던 숫자 중 가장 첫번째 숫자는 제외하고 nums로 들어감.
		int sum = 0;

		for (int data : nums) { // nums에 가변인자들이 배열을 이뤄 들어감

			sum += data; // nums안에 있는 가변인자들이 sum변수에 계속들어감
		}

		return sum;
	}
	// public static int add(int[] a) { 이미 위의 nums가 곧 int형 배열이기때문에 매개변수가 같아서 오버로딩이
	// 안됨.
	// 배열을 쓰려면 데이터를 넘길때 아예 배열로 만들어서 호출해줘야함.
	// }

	
	//*************************************leftpad***********************************
	
	public   String leftPad(String str, int size, char padChar) {

		for (int a = str.length(); a < size; a++) {
			// if를 안써도 포문에서 조건을 맞게 걸어줬기 때문에
			// 똑같이 움직임. 이렇게 하면 불필요한 동작이 최소화됨.
			// if(str.length()< size) {

			str = padChar + str; // 연산그대로다. 차 # 옆에 문자열 bit.

			// }

		}

		return str;

	}
	//*********************************rightpad*************************************]
	
	public  static String rightPad(String str, int size, char padChar) {

		for (int a = str.length(); a < size; a++) {
			// if를 안써도 포문에서 조건을 맞게 걸어줬기 때문에
			// 똑같이 움직임. 이렇게 하면 불필요한 동작이 최소화됨.
			// if(str.length()< size) {

			str = str + padChar; // 연산그대로다. 차 # 옆에 문자열 bit.

			// }

		}

		return str;

	}
	//************************sort 정렬함수***********************************
	
	public int[] sort(int[] nums) { // 인트타입의 배열로 리턴
		//지금 이 정렬하는 메소드를 자주 쓰기때문에 함수로 만들어 바로바로 정렬 메소드를 호출한다
		int[] data2 = new int[nums.length];
		int count = 0;

		System.arraycopy(nums, 0, data2, 0, nums.length); //어레이카피 중요 ************
		
		//넘즈와 똑같은 배열 data2를 만들어서 정ㄹ렬하고 그 값을 리턴함. 그럼 함수를 수행한 s.sort(data)는 
		//정리된 data2 배열값을 받아서 정렬되어있고 그냥 data는 아무값도 반환받지 못하여 원본배열 그대로다.
		for (int a = 0; a < data2.length - 1; a++) {
			int min = a;
			for (int b = a + 1; b < data2.length; b++) {
				if (data2[min] > data2[b]) {
					min = b;

				}

			}
			int tmp = data2[a];
			data2[a] = data2[min];
			data2[min] = tmp;

		}

		return data2;
	
	}
	
	
}
