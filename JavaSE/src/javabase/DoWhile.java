package javabase;

public class DoWhile {
	public static void main(String[] args){
		int a=1;
		int sum=0;
		
		/*
		 do while 与while循环的区别 
		 while条件为false一次也不执行,do while会执行一次 
		 */		
		
		
		do{
			sum+=a;
			++a;
		}
		while(a<=100);
		
		System.out.println(sum);
	}
}
