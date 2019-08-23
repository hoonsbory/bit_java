package test;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

import util.jdbc_util;

public class test04_login {
	public static void main(String[] args) {
		System.out.println("============로그인 처리=============");
		jdbc_util j = new jdbc_util();

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		String sql = "select * from users where id='java01' and password ='1234'";
		try {
			con = j.con2();
			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				System.out.println(rs.getString("id") + "님 로그인 되었습니다");
				System.out.printf("아이디 =%s , 이름 = %s ", rs.getString("id"), rs.getString("name"));
			} else {
				System.out.println("로그인 실패");

			}

		} catch (Exception e) {
		} finally {
			j.close(con, st, rs);

		}

	}
}
