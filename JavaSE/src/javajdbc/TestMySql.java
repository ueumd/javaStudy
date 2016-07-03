package javajdbc;

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
	
}
