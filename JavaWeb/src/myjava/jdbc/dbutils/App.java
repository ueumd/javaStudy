package myjava.jdbc.dbutils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import myjava.jdbc.eg.JdbcUtil;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

public class App {
	private Connection conn;
	
	@Test
	public void test() throws Exception{
		String sql="select * from admin where id=?";
		conn=JdbcUtil.getConnection();
		
		QueryRunner qr=new QueryRunner();
		Admin admin=qr.query(conn, sql, new ResultSetHandler<Admin>(){
			public Admin handle(ResultSet rs) throws SQLException{
				if(rs.next()){
					Admin admin=new Admin();
					admin.setId(rs.getInt("id"));
					admin.setUserName(rs.getString("userName"));
					return admin;
					
				}
				return null;
			}
			
		}, 11);
		
		System.out.println(admin);
		conn.close();
	}
	
	@Test
	public void test2() throws Exception{
		String sql="select * from admin where id=?";
		conn=JdbcUtil.getConnection();
		
		QueryRunner qr=new QueryRunner();
		//返回单个对象
		Admin admin=qr.query(conn, sql, new BeanHandler<Admin>(Admin.class),7);
		
		System.out.println(admin);
		conn.close();
	}
	
	@Test
	public void test3() throws Exception{
		String sql="select * from admin";
		conn=JdbcUtil.getConnection();
		
		QueryRunner qr=new QueryRunner();
	
		List<Admin> list=qr.query(conn, sql, new BeanListHandler<Admin>(Admin.class));
		
		System.out.println(list);
		conn.close();
	}
}
