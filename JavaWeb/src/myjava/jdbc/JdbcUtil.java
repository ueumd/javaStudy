package myjava.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	private static String url="jdbc:mysql://localhost:3306/myjava";
	private static String user="root";
	private static String password="51134642";
		
	/**
	 * 静态代码块中（只加载一次）
	 */
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("驱动程序注册出错");
		}
	}
	
	/**
	 * 获取连接对象的方法
	 * @return
	 */
	public static Connection getConnection(){
		try {
			Connection conn=DriverManager.getConnection(url,user,password);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	/**
	 * 关闭资源
	 * @param conn
	 * @param stmt
	 */
	public static void close(Connection conn,Statement stmt){
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
