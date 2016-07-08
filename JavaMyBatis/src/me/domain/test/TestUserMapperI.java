package me.domain.test;

import java.io.InputStream;
import java.util.List;

import me.domain.javaclass.User;
import me.domain.util.MyBatisUtil;
import me.mapping.UserMapperI;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestUserMapperI {

	@Test
	public void add() {
		// 配置mybatis文件
		String resource = "conf.xml";

		// 使用类加载mybatis配置文件
		InputStream is = TestUserMapperI.class.getClassLoader()
				.getResourceAsStream(resource);

		// 构建工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
				.build(is);

		// 创建能执行映射文件中sql的SqlSession

		SqlSession sqlsession = sessionFactory.openSession();

		UserMapperI mapper = sqlsession.getMapper(UserMapperI.class);

		User user = new User();
		user.setName("用户xrp");
		user.setAge(20);

		int add = mapper.add(user);

		sqlsession.close();

		System.out.println(add);
	}
	
	@Test
	public void testGetAll(){
		SqlSession sqlSession=MyBatisUtil.getSqlSession();
		UserMapperI mapper=sqlSession.getMapper(UserMapperI.class);
		
		List<User> list=mapper.getAll();
		
		sqlSession.close();
		System.out.println(list);
	}
}
