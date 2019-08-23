package util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class jdbc_util {

	public static Connection con = null;
	Connection con2 = null;
	static Statement st = null;
	Statement st2 = null;
	static ResultSet rs = null; // select의 결과값을 받을 객체.
	public static void main(String[] args) {
		int deptno = 20;
		if(args.length!=0) {
		 deptno = Integer.parseInt(args[0]);
		}
		String sql = "select * from emp where deptno = "+ deptno ;
		con("C://lib//dbinfo.txt");
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.print(rs.getInt("deptno") + "\t");
				//컬럼 네임말고 인덱스가 와도 된다.
				System.out.print(rs.getString("ename") + "\t");
				System.out.print(rs.getDate("hiredate") + "\t");
				System.out.print(rs.getInt("sal") + "\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}close(con,st,rs);
	}
	
	//Connection 생성
	public static void con(String str) { //파라미터로 파일 경로 지정해서 로드하는 방법
		FileReader fr = null;
		Properties p1 = new Properties();
		

		
		try {
			fr = new FileReader(str);  //파일 인풋 스트림도 가능.
			p1.load(fr);
			try {
				Class.forName(p1.getProperty("driver"));
				try {
					con = DriverManager.getConnection(p1.getProperty("url"), p1.getProperty("user"), p1.getProperty("pw"));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
				try {
					if(fr !=null)
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
			
	}
	
	public static Connection con2() {  //파일경로를 박아놓고 커넥션 타입을 리턴하는 방법.
		FileReader fr = null;
		Properties p1 = new Properties();
		

		
		try {
			fr = new FileReader("C://lib//dbinfo.txt");  //파일 인풋 스트림도 가능.
			p1.load(fr);
			try {
				Class.forName(p1.getProperty("driver"));
				try {
					con = DriverManager.getConnection(p1.getProperty("url"), p1.getProperty("user"), p1.getProperty("pw"));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
				try {
					if(fr !=null)
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return con;
			
	}
	//자원 반납
	
	public static void close(Connection con, Statement st, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
	}
	
}
}
