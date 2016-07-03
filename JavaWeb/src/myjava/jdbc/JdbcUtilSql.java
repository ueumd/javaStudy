package myjava.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
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
	
	@Test
	public void testQuery() throws Exception{
		Connection conn=null;
		Statement stmt=null;
		try{
			conn=JdbcUtil.getConnection();
			
			stmt=conn.createStatement();
			
			String sql="select * from student";
			
			ResultSet rs=stmt.executeQuery(sql); //执行静态Sql语句
			
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String gender=rs.getString("gender");
				
				System.out.println(id+","+name+","+gender);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn, stmt);
		}
	}
}
