package javaObject;

import org.junit.Test;
import java.util.Arrays;

public class ArrayTest3 {
	@Test
	public void test(){
		
		int[] a={1,2,3};
		int[] b={1,2,3};
		
		System.out.println(Arrays.equals(a, b));//true
		System.out.println(this.isEquals(a, b));//true
		
	}
	
	public boolean isEquals(int[] a,int[] b){
		if(a==null || b==null){
			return false;
		}
		
		if(a.length!=b.length){
			return false;
		}
		
		for(int i=0;i<a.length;i++){
			if(a[i]!=b[i]){
				return false;
			}
		}
		
		return true;
	}
}
