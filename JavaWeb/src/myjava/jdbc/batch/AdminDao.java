package myjava.jdbc.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import myjava.jdbc.eg.JdbcUtil;

public class AdminDao {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	public void save(List<Admin> list){
		String sql="insert into admin(username,pwd) values(?,?)";
		try{
			conn=JdbcUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			for(int i=0;i<list.size();i++){
				Admin admin=list.get(i);
				
				pstmt.setString(1,admin.getUserName());
				pstmt.setString(2, admin.getPwd());
				
				//添加批处理
				pstmt.addBatch();
				
				// 测试：每5条执行一次批处理
				if(i%5==0){
					//批量执行
					pstmt.executeBatch();
					//清空批处理
					pstmt.clearBatch();
				}
			}
			
			//批量执行
			pstmt.executeBatch();
			//清空批处理
			pstmt.clearBatch();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt, rs);
		}
	}
}
