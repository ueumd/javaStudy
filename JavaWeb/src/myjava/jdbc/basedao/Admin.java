package myjava.jdbc.basedao;

public class Admin {
	private int id;
	private String username;
	private String pwd;
	
	protected int getId() {
		return id;
	}
	protected void setId(int id) {
		this.id = id;
	}
	protected String getUsername() {
		return username;
	}
	protected void setUsername(String username) {
		this.username = username;
	}
	protected String getPwd() {
		return pwd;
	}
	protected void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", pwd=" + pwd+ "]";
	}
	
}
