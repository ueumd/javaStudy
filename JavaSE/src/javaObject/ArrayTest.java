package javaObject;

import org.junit.Test;

public class ArrayTest {

	@Test
	public void test(){
		int[] a=new int[100];
		
		for(int i=0;i<a.length;i++){
			a[i]=i+1;
		}
		
		for(int i=0;i<a.length;i++){
			//System.out.println("a["+i+"]:"+a[i]);
		}
		
		/*
		 * a.length=200; length属性是public final int的，数组长
		度一旦确定后是不能改变的
		*/
		
		int[] a1=new int[4];
		
		System.out.println(a1[0]);//0
		
		boolean[] b=new boolean[3];
		System.out.println(b[0]);//false
		
		int[] a3={1,2,3};
		int[] a4={1,2,3};
		
		//数组没有重写Ojbect.equals方法，所以比较是两个对象的地址
		System.out.println(a3.equals(a4)); //false
		
	}
}
