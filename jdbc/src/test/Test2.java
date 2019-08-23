package test;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test2 {
	public static void main(String[] args) {
		System.out.println("===============jdbc 테스트=============");
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "SCOTT"; // 다른 계정도 모두 가능.
		String pw = "TIGER";
		// db연동할 때 필요한 정보들.
//		String sql = "select e.ename as \"사원명\" , e.sal as \"급여\" , m.ename as \"상사명\" ,  m.sal as 상사급여 " + 
//		"from emp e " + 
//				"join emp m " + 
//		"on e.mgr =  m.empno "+
//		"where e.sal > m.sal ";
		//영문이름으로 얼라이어스 해주고 더블코테이션 닫기 전에 한 칸 띄어쓰자.
		String sql = "select * from emp_dept";
		//String sql2 = "insert into dept values(50, 'bitcamp' , 'seoul')";
		String sql2 = "delete from dept where deptno = 50";

		Connection con = null;
		Statement st = null;

		ResultSet rs = null; // select의 결과값을 받을 객체.
		int result = 0; // dml의 결과값.

		// 1. jdbc driver 설치 : ojdbc6.jar를 classpath에 추가해야 인식이 됨. 프로젝트 우클릭 후 빌드패스 >>
		// 컨피규어 빌드패스 >> 라이브러리에서 외부자르 추가.

		// 2. 드라이버 로딩 = driver를 메모리에 올린다.
		// new oracle.jdbc.OracleDriver() 뉴 키워드는 메모리에 올라갈 클래스가 컴파일 타임에 결정이 됨.
		// Class.forName은 런타임에 결정됨. 때문에 뉴키워드는 오라클만 쓸 수 있다.
		try {
			Class.forName(driver);
			// 3. DB로 연결 Connection 생성
			con = DriverManager.getConnection(url, user, pw);
			// 4. sql 구문을 관리해주는 관리 객체(Statement) 생성
			st = con.createStatement();
			// 5 . sql 구문 실행
			rs = st.executeQuery(sql);
			// System.out.println(rs.getMetaData().getColumnCount()); //컬럼 갯수 출력.
			// 6. 결과값 핸들링
			while (rs.next()) {
				System.out.print(rs.getString(1) + "\t");
				//컬럼 네임말고 인덱스가 와도 된다.
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getString(4) + "\t");
				System.out.print(rs.getString(5) + "\n");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc 드라이버 확인");
			// 위 에러가 출력되면 클래스패스부터 확인하고 그 다음 드라이버 이름 확인.
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// 7. 자원반납
			try {
				if (st != null)
					st.close();
				if (con != null)
					con.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		System.out.println("===============jdbc 테스트종료=============");
	}
}
