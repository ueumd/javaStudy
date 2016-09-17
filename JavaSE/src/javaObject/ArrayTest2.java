package javaObject;

import org.junit.Test;

public class ArrayTest2 {

	@Test
	public void test(){
		Stu[] s=new Stu[100];
		
		for(int i=0;i<s.length;i++){
			s[i]=new Stu();
			
			if(i%2==0){
				s[i].name="zhangsan";
			}else{
				s[i].name="lishi";
			}
		}
		
		for(int i=0;i<s.length;i++){
			System.out.println(s[i].name);
		}
		
	}
}

class Stu{
	String name;
}