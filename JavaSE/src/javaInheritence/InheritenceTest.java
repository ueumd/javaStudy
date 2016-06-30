package javaInheritence;

public class InheritenceTest {

	public static void main(String[] args) {
		Apple apple=new Apple();
		
		System.out.println(apple.name);

	}

}

class Fruit{
	String name="fruit";
}

class Apple extends Fruit{
	
	/*
	 
	 继承的3点：
	 1、父类有的，子类也有
	 2、父类没有的，子类可以增加加
	 3、父类有的，子类可以改变
	 
	  继承的注意事项
	  1、构造方法不能被继承
	  2、子类的构造方法隐式地调用父类的不带参数的构造方法
	  3、当父类没有不带参数的构造方法时，子类需要使用super来
	  	显示地调用父类的构造方法，spuer指的是对父类的引用
  	  4、super关键字必须是构造方法中的第一行语句。
	 
	*/
	String name="apple";
}
