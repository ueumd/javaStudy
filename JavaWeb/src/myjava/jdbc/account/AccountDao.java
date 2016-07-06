package myjava.jdbc.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import myjava.jdbc.eg.JdbcUtil;

public class AccountDao {

	private Connection conn;
	private PreparedStatement pstmt;
	
	public void trans(){
		String sql_zs = "UPDATE account SET money=money-1000 WHERE accountName='张三';";
		String sql_ls = "UPDATE account SET money=money+1000 WHERE accountName='李四';";
		
		try{
			conn=JdbcUtil.getConnection();//默认开启了隐士事务
			
			pstmt=conn.prepareStatement(sql_zs);
			pstmt.executeUpdate();
			
			pstmt=conn.prepareStatement(sql_ls);
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			JdbcUtil.close(conn, pstmt, null);
		}
	}
	
	public void trans2(){
		String sql_zs = "UPDATE account SET money=money-1000 WHERE accountName='张三';";
		String sql_ls = "UPDATEd account SET money=money+1000 WHERE accountName='李四';";
		
		try{
			conn=JdbcUtil.getConnection();//默认开启了隐士事务
			
			//设置事务为手动提交
			conn.setAutoCommit(false);
			
			pstmt=conn.prepareStatement(sql_zs);
			pstmt.executeUpdate();
			
			pstmt=conn.prepareStatement(sql_ls);
			pstmt.executeUpdate();
			
		}catch(Exception e){
			try{
				//出现异常需要回滚
				conn.rollback();
			}catch(SQLException el){
				
			}
			e.printStackTrace();
		}
		finally{
			try{
				conn.commit();
				JdbcUtil.close(conn, pstmt, null);
			}catch(SQLException e){
				
			}
		}
		
	}
	
	public void trans3() {
		// 定义个标记
		Savepoint sp = null;
		
		// 第一次转账
		String sql_zs1 = "UPDATE account SET money=money-1000 WHERE accountName='张三';";
		String sql_ls1 = "UPDATE account SET money=money+1000 WHERE accountName='李四';";
		
		// 第二次转账
		String sql_zs2 = "UPDATE account SET money=money-500 WHERE accountName='张三';";
		String sql_ls2 = "UPDATE1 account SET money=money+500 WHERE accountName='李四';";

		try {
			conn = JdbcUtil.getConnection(); // 默认开启的隐士事务
			conn.setAutoCommit(false);       // 设置事务手动提交

			/*** 第一次转账 ***/
			pstmt = conn.prepareStatement(sql_zs1);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql_ls1);
			pstmt.executeUpdate();
			
			// 回滚到这个位置？
			sp = conn.setSavepoint(); 
			
			
			/*** 第二次转账 ***/
			pstmt = conn.prepareStatement(sql_zs2);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql_ls2);
			pstmt.executeUpdate();
			

		} catch (Exception e) {
			try {
				// 回滚 (回滚到指定的代码段)
				conn.rollback(sp);
			} catch (SQLException e1) {
			}
			e.printStackTrace();
		} finally {
			try {
				// 提交
				conn.commit();
			} catch (SQLException e) {
			}
			JdbcUtil.close(conn, pstmt, null);
		}

	}
}
