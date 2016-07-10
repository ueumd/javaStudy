package me.domain.test;

import me.domain.util.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import me.domain.moreselect.*;

public class TestTeaAndCalsses {
	@Test
	public void test1(){
		SqlSession sqlSession=MyBatisUtil.getSqlSession();
		
		String statement="me.mapping.classMapper.getTeaById";
		
		Teacher tea=sqlSession.selectOne(statement,1);
		
		sqlSession.close();
		
		System.out.println(tea);
	}
	
	@Test
	public void test2(){
		SqlSession sqlSession=MyBatisUtil.getSqlSession();
		
		String statement="me.mapping.classMapper.getClass";
		
		Classes clazz=sqlSession.selectOne(statement,1);
		
		sqlSession.close();
		
		System.out.println(clazz);
	}
	/**
	 * 　根据classId查询对应的班级信息,包括学生,老师
	 */
	@Test
	public void testGetClass3(){
		SqlSession sqlSession=MyBatisUtil.getSqlSession();
		
		String statement="me.mapping.classMapper.getClass3";
		
		Classes clazz=sqlSession.selectOne(statement,1);
		
		sqlSession.close();
		
		System.out.println(clazz);
	}
	
	/**
	 * 　根据classId查询对应的班级信息,包括学生,老师
	 */
	@Test
	public void testGetClasst4(){
		SqlSession sqlSession=MyBatisUtil.getSqlSession();
		
		String statement="me.mapping.classMapper.getClass4";
		
		Classes clazz=sqlSession.selectOne(statement,1);
		
		sqlSession.close();
		
		System.out.println(clazz);
	}
}
