package javaObject;

import org.junit.Test;

public class ObjectTest {

	@Test
	public void test(){
		
		/**
		 * Object equals方法是比较两个结象的引用是否一样
		 * 
		 * String equals方法是重写了Object的equals方法，比较的是内容一样
		 */
		
		Object o1=new Object();
		
		Object o2=new Object();
		
		System.out.println(o1.equals(o2));//false
		
		Student s1=new Student("zhangshan");
		Student s2=new Student("zhangshan");
		
		//Student类继承Object类 重写 equals方法后为true
		System.out.println(s1.equals(s2));//false
		
		
		System.out.println(o1); 			//java.lang.Object@1935d392
		System.out.println(o1.toString());  //java.lang.Object@1935d392
		
		//javaObject.Student@6cf82c7d
		//重写	toString方法
		System.out.println(s1); 	//zhangshan
		System.out.println(s1.toString()); 	//zhangshan
		
	}
}

class Student{
	String name;
	
	public Student(String name){
		this.name=name;
	}
	
	public boolean equals(Object anObject){
		if(this==anObject){
			return true;
		}
		
		if(anObject instanceof Student){
			Student student=(Student)anObject;
			
			if(student.name.equals(this.name)){
				return true;
			}
		}
		
		return false;
	}
	
	public String toString(){
		return this.name;
	}
	
}
