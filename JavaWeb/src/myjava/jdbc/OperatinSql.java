package myjava.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class OperatinSql {
	
	private String url="jdbc:mysql://localhost:3306/myjava";
	private String user="root";
	private String pass="51134642";
	
	/**
	 * 插入
	 * @throws Exception
	 */
	@Test
	public void testInsert() throws Exception{

		Connection conn=null;
		Statement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn=DriverManager.getConnection(url,user,pass);
			
			stmt=conn.createStatement();
			
			String sql="insert into student(name,gender) values('李四','女')";
			
			int count=stmt.executeUpdate(sql);
			
			System.out.println("影响:"+count);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			
			//关闭资源
			if(stmt!=null){
				try{
					stmt.close();
				}catch(SQLException e){
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
			if(conn!=null) {
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
		
	}
	
	@Test
	public void testUpdate() throws Exception{
		Connection conn=null;
		Statement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn=DriverManager.getConnection(url,user,pass);
			
			stmt=conn.createStatement();
			
			String sql="update student set name='王五' where id=1";
			
			int count=stmt.executeUpdate(sql);
			
			System.out.println("修改影响:"+count);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			
			//关闭资源
			if(stmt!=null){
				try{
					stmt.close();
				}catch(SQLException e){
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
			if(conn!=null) {
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
		
	}
	
	
	
	
}
