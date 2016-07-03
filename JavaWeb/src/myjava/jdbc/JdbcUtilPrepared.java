package myjava.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

/**
 * 
 * @author Administrator
 * PreparedStatement与Statement
 * 1、前者使用sql缓存区，比后者效律高
 * 2、前者可以有效防止SQL注入
 * 3、前者可以使用预编译的sql语句
 */

public class JdbcUtilPrepared {
	Connection conn=null;
	PreparedStatement stmt=null;
	CallableStatement ctmt=null;//存诸过程
	ResultSet rs=null;
	
	
	@Test
	public void insert(){
		try{
			conn=JdbcUtil.getConnection();
			
			String sql="insert into student(NAME,gender) values(?,?)";//?表示参数占位符
			
			//执行预编译sql语句（检查语法）
			stmt=conn.prepareStatement(sql);
			
			/**
			 * 设置参数值 
			 * 1、位置从1开始
			 */
			stmt.setString(1,"李小子");
			stmt.setString(2,"男");
			
			//发送
			
			int count =stmt.executeUpdate();
			
			System.out.println("修改影响:"+count);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn, stmt);
		}
	}
	
	@Test
	public void update(){
		try{
			conn=JdbcUtil.getConnection();
			
			String sql="update student set name=? where id=?";//?表示参数占位符
			
			//执行预编译sql语句（检查语法）
			stmt=conn.prepareStatement(sql);
			
			/**
			 * 设置参数值 
			 * 1、位置从1开始
			 */
			stmt.setString(1,"李小小");
			stmt.setInt(2, 5);
			
			//发送
			
			int count =stmt.executeUpdate();
			
			System.out.println("修改影响:"+count);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn, stmt);
		}
	}
	
	@Test
	public void remove(){
		try{
			conn=JdbcUtil.getConnection();
			
			String sql="delete from student where id=?";//?表示参数占位符
			
			//执行预编译sql语句（检查语法）
			stmt=conn.prepareStatement(sql);
			
			/**
			 * 设置参数值 
			 * 1、位置从1开始
			 */

			stmt.setInt(1, 6);
			
			//发送
			
			int count =stmt.executeUpdate();
			
			System.out.println("修改影响:"+count);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn, stmt);
		}
	}
	
	@Test
	public void query(){
		try{
			conn=JdbcUtil.getConnection();
			
			String sql="select * from student";//?表示参数占位符
			
			//执行预编译sql语句（检查语法）
			stmt=conn.prepareStatement(sql);

			//发送并执行
			rs=stmt.executeQuery();
			
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
			JdbcUtil.close(conn, stmt,rs);
		}
	}
	
	/**
	 * 使用存储过程 call pro_findById(?)
	 */
	@Test
	public void callable(){
		try{
			conn=JdbcUtil.getConnection();
			
			String sql="call pro_findById(?)";
			
			//执行预编译sql语句（检查语法）
			ctmt=conn.prepareCall(sql);
			
			ctmt.setInt(1,4);
			
			//发送并执行 所有使用存储过程的都使用executeQuery()
			rs=ctmt.executeQuery();
			
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
			JdbcUtil.close(conn, stmt,rs);
		}
	}
}
