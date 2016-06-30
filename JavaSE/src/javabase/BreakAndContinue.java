package javabase;

public class BreakAndContinue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++){
			if(5==i){
				break;//跳出整个循环，执行循环后面的代码
			}
			System.out.print(i);//01234
			
		}
		System.out.println('\n');
		for(int j=0;j<10;j++){
			if(5==j){
				continue;//用于跳出当前这个循环,开始一下次循环的执行
			}
			System.out.print(j);//012346789
		}
	}

}
