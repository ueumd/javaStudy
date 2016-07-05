package myjava.jdbc.basedao;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import myjava.jdbc.eg.JdbcUtil;

import org.junit.Test;




public class GetSqlParams {

	@Test
	public void test() throws Exception{
		Connection conn=JdbcUtil.getConnection();
		
		String sql="select * from admin where id=? and pwd=?";
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		
		//参数的元数据
		ParameterMetaData metaData=pstmt.getParameterMetaData();
		
		//参数的个数
		int count=metaData.getParameterCount();
		
		System.out.println(count);
	}
	
	@Test
	public void test2() throws Exception{
		String sql="select * from admin";
		
		Connection conn=JdbcUtil.getConnection();
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		//得到结果集元数据（目标：通过结果集元数据，得到列的名称）
		ResultSetMetaData metaData=rs.getMetaData();
		
	
		while(rs.next()){
			//获取列的个数
			int count=metaData.getColumnCount();
			//遍历 获取每列的名称
			for(int i=0;i<count;i++){
				//列的名称
				String columnName=metaData.getColumnName(i+1);
				//列的值
				Object columnValue=rs.getObject(columnName);
				
				System.out.println(columnName+"="+columnValue+", ");
			}
			System.out.println();
		}
		
	}
}
