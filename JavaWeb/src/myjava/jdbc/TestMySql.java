package myjava.jdbc;

import org.junit.Test;

import java.sql.*;
import java.util.Properties;

public class TestMySql {
						//协议：数据库子协议：主机：端口：数据库
	private String url="jdbc:mysql://localhost:3306/myjava";
	private String user="root";
	private String password="51134642";
	
	@Test
	public void test1() throws Exception{
		//创建驱动类程序 需要导入mysql的jar包
		Driver driver=new com.mysql.jdbc.Driver();
		
		Properties props=new Properties();
		props.setProperty("user", user);
		props.setProperty("password", password);
		
		//边接数据库
		Connection conn=driver.connect(url,props);
		
		System.out.println(conn);
	}
	
	/**
	 * 使用驱动程序管理器类边接数据库
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception{
		Driver driver=new com.mysql.jdbc.Driver();
		
		//注册驱动 上一句直接注册了
		//DriverManager.registerDriver(driver);
		
		//连接到具体数据库
		Connection conn=DriverManager.getConnection(url,user,password);
		
		System.out.println("connected:"+conn);
		//关闭连接
		conn.close();
	}
	
	@Test
	public void test3() throws Exception{
		Connection conn=null;
		try{
			//通过得到字节码对象的方式加载静态代码块，从而注册驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			
			//连接到具体数据库
			conn=DriverManager.getConnection(url,user,password);
			
			System.out.println("connected3:"+conn);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//关闭连接
			conn.close();
		}
	}
	
	@Test
	public void test4() throws Exception{
		Connection conn=null;
		Statement stmt=null;
		
		try{
			//1注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//2获取连接对象
			conn=DriverManager.getConnection(url,user,password);
			
			//3创建Statement
			stmt=conn.createStatement();
			
			//4sql
			String sql="CREATE TABLE student(id INT PRIMARY KEY AUTO_INCREMENT,NAME VARCHAR(20),gender VARCHAR(2));";
			
			//5发送sql语句，执行SQL语句，得到返回结果
			int count=stmt.executeUpdate(sql);
			
			//6输入出
			System.out.println("影响了:"+count);
			
			System.out.println("connected4:"+conn);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
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
					System.out.println("conn closed");
				}catch(SQLException e){
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		
		}
	}
	
	
}
