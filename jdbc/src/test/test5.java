package test;

import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.jdbc_util;

public class test5 {
	public static void main(String[] args) {
		System.out.println("============로그인 처리=============");
		jdbc_util j = new jdbc_util();

		Connection con = null;
		//Statement st = null; ?물음표 처리 안됨
		PreparedStatement ps = null; //sql 구문중에 물음표가 있을 때 처리할 수 있는 관리객체  보통 이걸 많이 씀
		//물음표를 써야 보안에 강함.
		ResultSet rs = null;
		String id = JOptionPane.showInputDialog("id입력");
		String pw = JOptionPane.showInputDialog("pw입력");
		
		
//		String sql = "select * from users where id='"+ id + "'and password ='" + pw+"'"; 
		//sql구문이라 변수 바인딩할때 싱글코테이션 해줘야한다. 위 구문은 해킹위험이 매우높다 ㅎ sql인잭션의 대상이 됨
		String sql = "select * from users where id=? and password =?";
		//어떤 값이 들어올지 모르니 ? 처리함. ?는 Statement못씀
		try {
			con = j.con2();
			ps = con.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2,pw);
			rs = ps.executeQuery();

			if (rs.next()) { //아이디 비번이 맞으면 로우 하나가 날라와서  한 줄씩 읽는 next함수를 통해 if조건이 만족한다.
				System.out.println(rs.getString("id") + "님 로그인 되었습니다");
				System.out.printf("아이디 =%s , 이름 = %s ", rs.getString("id"), rs.getString("name"));
			} else {
				System.out.println("로그인 실패");

			}

		} catch (Exception e) {
		} finally {
			j.close(con, ps, rs);

		}

	}
}
