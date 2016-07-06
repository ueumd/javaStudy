package myjava.jdbc.basedao;

public class Admin {
	private int id;
	private String username;
	private String pwd;

	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", pwd=" + pwd
				+ "]";
	}
	
}
