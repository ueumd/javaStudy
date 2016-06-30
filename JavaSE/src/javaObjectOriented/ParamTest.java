package javaObjectOriented;

public class ParamTest {
	
	public void changePoint(Point p){
		p.x=3;
		p.y=4;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ParamTest p=new ParamTest();
		Point point=new Point();
		p.changePoint(point);
		
		System.out.println(point.x);
		System.out.println(point.y);
	}

}

class Point{
	int x;
	int y;
}
