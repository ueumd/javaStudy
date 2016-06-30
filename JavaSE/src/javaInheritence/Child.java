package javaInheritence;

public class Child extends Parent {

	public Child(){
		super(1);//如果用super调用父类特定的构造方法 调有带有参数的,不带参数不再执行
		System.out.println("child");
	}
	public static void main(String[] args) {	
		//先执行父类不带参数的构造方法 再执行子类构造方法
		Child child=new Child();// no args parent, child
	}

}

class Parent{
	
	public Parent(){
		System.out.println("no args parent");
	}
	
	public Parent(int i){
		System.out.println("parent");
	}
}
