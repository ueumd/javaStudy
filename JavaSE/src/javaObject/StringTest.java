package javaObject;

import org.junit.Test;

public class StringTest {
	@Test
	public void  test() throws Exception{
		/**
		 * String s=new String("sss");
		 * 
		 *1、首先在String Pool中查找有没有'sss'这个字符串对象，如果有，则
		 * 	不在String pool中再去创建"sss"这个对象了，直接在堆中(heap)中
		 *	创建一个"aaa"字符串对象，然后将堆中的这个"sss"对象的地址返回来
		 *	赋给s引用，导致s指向了堆中创建的这个"sss"字符串对象。
		 *
		 *2、如果没有，则首先在String Pool中创建一个"sss"对象，然后再在
		 *堆中(heap)创建一个"sss"对象，然后将堆中这个"sss"对象的地址返回
		 *来赋给s引用，导致s指向了堆中创建的这个"sss"字符串对象。
		 */
		
		String s=new String("sss");
		
		
		String str=new String("aaa");
		String str2=new String("aaa");
		
		System.out.println(str==str2);//false 堆中不同的对象
		
		System.out.println(str.equals(str2));//true 内容
		
		String str3="bbbb"; //不会创建对象
		String str4="bbbb";//创建了对象
		System.out.println(str3==str4);//true 栈中String Pool
		
		System.out.println(str3.equals(str4));//true
	}
}
