package myjava.jdbc.account;

import org.junit.Test;

public class App {
	@Test
	public void testname() throws Exception{
		AccountDao dao=new AccountDao();
		dao.trans3();
	}
}
