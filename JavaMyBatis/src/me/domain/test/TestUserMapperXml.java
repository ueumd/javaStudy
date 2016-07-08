package me.domain.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import me.domain.javaclass.User;
import me.domain.util.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestUserMapperXml {
	@Test
	public void test() {
		// mybatis的配置文件
		String resource = "conf.xml";

		// 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
		InputStream is = TestUserMapperXml.class.getClassLoader().getResourceAsStream(resource);

		// 构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

		// 创建能执行映射文件中sql的sqlSession
		SqlSession session = sessionFactory.openSession();

		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "me.mapping.userMapper.getUser";// 映射sql的标识字符串

		// 执行查询返回一个唯一user对象的sql
		User user = session.selectOne(statement, 1);
		System.out.println(user);
	}
	@Test
	public void testAdd(){
		 SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
		 
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * addUser是insert标签的id属性值，通过insert标签的id属性值就可以找到要执行的SQL
		 */
		
		String statement="me.mapping.userMapper.addUser";// 映射sql的标识字符串
		
		User user=new User();
		user.setName("daysun");
		user.setAge(20);
		
		//执行插入操作
		
		int retResult=sqlSession.insert(statement,user);
		
		sqlSession.close();
		
		System.out.println(retResult);
	}
	
	@Test
	public void testUpdate(){
		SqlSession sqlSession=MyBatisUtil.getSqlSession(true);
		
		String statement="me.mapping.userMapper.updateUser";
		
		User user=new User();
		user.setId(1);
		user.setName("Jack");
		user.setAge(20);
		
		int retResult=sqlSession.update(statement, user);
		
		sqlSession.close();
		System.out.println(retResult);
		
	}
	
	@Test
	public void testGetAll(){
		//配置mybatis文件
		String resource="conf.xml";
		
		// 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
		InputStream is=TestUserMapperXml.class.getClassLoader().getResourceAsStream(resource);
		
		//创建sqlSession工厂
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		
		// 创建能执行映射文件中sql的sqlSession
		SqlSession session = factory.openSession();
		
		String statement="me.mapping.userMapper.getAllUsers";
		
		List<User> list=session.selectList(statement);
		
		session.close();
		
		System.out.println(list);
		
		
	}
	
}
