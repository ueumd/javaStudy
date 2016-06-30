package javaObjectOriented;

public class OverloadMethod {
	
	//方法重载须 参数类型和参数个数不一致
	public int change(int a){
		a++;
		System.out.println(a);
		return a;
	}
	
	public boolean change(boolean a,boolean b){
		System.out.println(a);
		System.out.println(b);
		if(a){
			return true;
		}else{
			return false;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OverloadMethod m=new OverloadMethod();
		m.change(1);
		m.change(true,false);

	}

}
