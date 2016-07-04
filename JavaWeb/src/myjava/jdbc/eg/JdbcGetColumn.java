package myjava.jdbc.eg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;
/**
 * 获取自动增长列
 * @author Administrator
 *
 */
public class JdbcGetColumn {
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	@Test
	public void test1() throws Exception{
		try{
			conn=JdbcUtil.getConnection();
			
			String sql="insert into student(NAME,gender) values(?,?)";
			
			//在参数中返回自动增长列
			pstmt=conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, "长江");
			pstmt.setString(2, "男");
			
			pstmt.executeUpdate();
			
			//获取列
			rs=pstmt.getGeneratedKeys();
			
			while(rs.next()){
				System.out.println("刚插入的列是："+rs.getInt(1));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt, rs);
		}
		
	}
}
