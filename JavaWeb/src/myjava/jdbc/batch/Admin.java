package myjava.jdbc.batch;
/**
 * 实体类
 * @author Administrator
 *
 */
public class Admin {
	private String userName;
	private String pwd;
	
	public String getUserName(){
		return userName;
	}
	
	public void setUserName(String userName){
		this.userName=userName;
	}
	
	public String getPwd(){
		return pwd;
	}
	
	public void setPwd(String pwd){
		this.pwd=pwd;
	}
}
