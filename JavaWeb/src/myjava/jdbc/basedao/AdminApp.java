package myjava.jdbc.basedao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AdminApp {
	@Test
	public void test(){
		AdminDao adminDao=new AdminDao();
		//adminDao.delete(8);
		//adminDao.save(new Admin());
		
		List<Admin> list=adminDao.getAll();
		System.out.println(list);
	}
}
