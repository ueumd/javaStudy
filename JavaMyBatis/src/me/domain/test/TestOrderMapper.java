package me.domain.test;

import me.domain.javaclass.Order;
import me.domain.util.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestOrderMapper {
	@Test
	public void testGetOrderById() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();

		/**
		 * 映射sql的标识字符串， me.mapping.orderMapper是orderMapper.
		 * xml文件中mapper标签的namespace属性的值，
		 * getOrderById是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */

		String statement = "me.mapping.orderMapper.getOrderById";

		Order order = sqlSession.selectOne(statement, 1);

		sqlSession.close();
		System.out.println(order); // 打印结果：null，也就是没有查询出相应的记录
	}

	@Test
	public void testGetOrderById2() {

		SqlSession sqlSession = MyBatisUtil.getSqlSession();

		/*	字段名 起了一个和 实体类属性名一样的名子就能查询出来
		 * <select id="selectOrder" parameterType="int" resultType="Order">
		 * 		select order_id id, order_no orderNo,order_price price from orders
		 * 		where order_id=#{id} 
		 * </select>
		 */
		String statement = "me.mapping.orderMapper.selectOrder";
		Order order = sqlSession.selectOne(statement, 1);

		sqlSession.close();
		System.out.println(order); // 打印结果：Order [id=1, orderNo=aaaa,
									// price=23.0]
	}
	
	@Test
	public void testGetOrderById3() {

		SqlSession sqlSession = MyBatisUtil.getSqlSession();

		/* 
		 * 通过<resultMap>映射实体类属性名和表的字段名对应关系 
		*/
		String statement = "me.mapping.orderMapper.selectOrderResultMap";
		Order order = sqlSession.selectOne(statement, 1);

		sqlSession.close();
		System.out.println(order); // 打印结果：Order [id=1, orderNo=aaaa,
									// price=23.0]
	}
}
