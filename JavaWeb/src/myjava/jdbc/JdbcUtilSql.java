package myjava.jdbc;

import org.junit.Test;
import java.sql.Connection;
import java.sql.Statement;

import myjava.jdbc.JdbcUtil;

public class JdbcUtilSql {
	@Test
	public void testUpdate() throws Exception{
		Connection conn=null;
		Statement stmt=null;
		try {
			conn=JdbcUtil.getConnection();
			
			stmt=conn.createStatement();
			
			String sql="update student set name='王小' where id=2";
			
			int count=stmt.executeUpdate(sql);
			
			System.out.println("修改影响:"+count);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn, stmt);
		}
		
	}
}
