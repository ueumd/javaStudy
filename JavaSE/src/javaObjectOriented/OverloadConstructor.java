package javaObjectOriented;

public class OverloadConstructor {

	public OverloadConstructor(){
		this(3);//调用当前对象带有参数的构造函数,且必须放在此第一行，this前不能有任何可执行的代码
		System.out.println("loaded");
	}
	public OverloadConstructor(int i){
		System.out.println(++i);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OverloadConstructor onew=new OverloadConstructor();//loaded
		OverloadConstructor two=new OverloadConstructor(10);//11
	}

}
