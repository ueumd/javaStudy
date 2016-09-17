package javaObject;

import org.junit.Test;
import java.util.Random;

public class RandomTest {

	@Test
	public void test() throws Exception{
		Random random=new Random();
		int[] count=new int[10];
		
		for(int i=0;i<10;i++){
			System.out.println(random.nextInt(11)+10);//[10-20]
			int number=random.nextInt(11)+10;

			count[number-10]++;
		}
		
		for(int i=0;i<count.length;i++){
			if(0==count[i]){
				continue;
			}
			
			System.out.println((i+10)+"出现次数"+count[i]);
		}
	}
}
