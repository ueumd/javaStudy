package myjava.jdbc.beanuitls;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class App {
	@Test
	public void app() throws Exception{
		String name = "jack";
		String age = "20";
		String birth = "2016-7-5";
		
		Admin admin =new Admin();
		/*admin.setUserName("beanutils");
		admin.setPwd("addd");*/
		
		// 注册日期类型转换器：2， 使用组件提供的转换器工具类
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		
		// b. BeanUtils组件实现对象属性的拷贝
		BeanUtils.copyProperty(admin, "userName", name); 
		BeanUtils.copyProperty(admin, "age", age);
		BeanUtils.copyProperty(admin, "birth", birth);
		
		System.out.println(admin.getUserName());
		System.out.println(admin.getAge());
		
		
		//对象的拷贝
		Admin newAdmin=new Admin();
		BeanUtils.copyProperties(newAdmin, admin);
		
		
		System.out.println(newAdmin.getUserName());
		System.out.println(newAdmin.getAge());
		System.out.println(newAdmin.getBirth());
		
		// d. map数据，拷贝到对象中
		Admin adminMap = new Admin();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userName", "Jerry");
		map.put("age", 29);
		// 注意：map中的key要与javabean的属性名称一致
		BeanUtils.populate(adminMap, map);
		
		System.out.println(adminMap.getUserName());
		System.out.println(adminMap.getAge());
	}
	
	public void convert(){
		// 注册日期类型转换器：1， 自定义的方式
		ConvertUtils.register(new Converter() {
			// 转换的内部实现方法，需要重写
			@Override
			public Object convert(Class type, Object value) {
				
				// 判断
				if (type != Date.class) {
					return null;
				}
				if (value == null || "".equals(value.toString().trim())) {
					return null;
				}
				
				
				try {
					// 字符串转换为日期
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					return sdf.parse(value.toString());
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
			}
		},Date.class);
	}
}
