package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.jdbc_util;

public class ex_0823 {
	static Connection con = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	static String sql = "select department_id as id, round(avg(salary),2) as avg \r\n" + 
			"from employees\r\n" + 
			"group by department_id\r\n" + 
			"having department_id = ?";
	private static void show(int DEPARTMENT_ID) {
		try {
			con = jdbc_util.con2();
			ps = con.prepareStatement(sql);
			ps.setLong(1, DEPARTMENT_ID);
			rs = ps.executeQuery(); 
			if (rs.next()) { 
				System.out.print(rs.getString("id") + "\t");
				System.out.print(rs.getString("avg") + "\n");
			} else {
				System.out.println("없는 부서입니다.");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			jdbc_util.close(con, ps, rs);
		}
		
			
	}
	
	public static void main(String[] args) {
		show(10);
		System.out.println("==============================");
		show(50);
	}
}
