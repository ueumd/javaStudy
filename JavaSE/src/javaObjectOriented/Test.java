package javaObjectOriented;

public class Test {
	
	/* 方法要定义在类中
	 * 1.方法返回类型与return后面的变量类型一致
	 * 2.方法调用时传递的参数与方法定义时的参数保持一致（个数和类型一致）
	 * 3、方法定义时与接收返回类型保持一致
	 */
	
	
	public int add(int a,int b){
		return a+b;
	}
	
	public int substract(int a,int b){//形式参数
		return a-b;
	}
	
	public void method(int a){
		if(a<10){
			//直接退出当前方法，并且不执行本方法return后面语句
			return;
		}
		System.out.println("Welcome to ShangHai");
	}
	
	public static void main(String[] args){
		
		Test test=new Test();
		int x=5;
		int y=8;
		
		int a=test.add(x,y);//实际参数
		int b=test.substract(x, y);
		
		System.out.println(a);
		System.out.println(b);
		
		int m=15;
		test.method(m);
	}
}
