package javaObjectOriented;

public class People {
	//成员变量
	int age=20;
	
	//构造方法
	public People(){
		
	}
	
	public People(int i){
		this.age=i;
	}
	
	public void change(People p){
		//p=new People();加上此句是又new了一个对象  不会对下面p影响
		 p.age=30;
	}
	
	public void change2(int age){
		//局部变量
		age=40;
	}
	
	public static void main(String[] args){
		
		/*
		 
		  引用类型（reference type） ：引用类型是用在对象上的。
		  一个对象可以被多个引用所指向，但同一时刻，每个引用只能指向唯一的一个对象。
		  如果一个对象被多个引用所指向，那么无论哪个引用对对象的属性进行了修改，都会反映到其他的引用当中。
		  
		 */
		
		/*
		 new 关键字干了3件事
		 1、 为对象开辟空间
		 2、调用类的构造方法
		 3、将生成的对象地址返回
		 
		 使用new生成对象时候 后面的小括号表示构造方法的参数列表
		 如果构造方法不接收参数，小括号的内容为空。
		 如果接收参数，那么参数需要与构造方法定义中形参保持一致（数量 、类型、顺序）
		 */
		
		People p=new People();
		System.out.println(p.age);//20
		
		p.change(p);
		System.out.println(p.age);//30
		
		int i=10;
		p.change2(i);//i 不是引用类型，所以还是10
		System.out.println(i);
		System.out.println(p.age);//30
	}
}
