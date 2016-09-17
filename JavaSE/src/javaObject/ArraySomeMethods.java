package javaObject;

import org.junit.Test;

public class ArraySomeMethods {
	@Test
	public void test(){
		int[] a={9,7,1,4};
		//this.bubbleSort(a);
		int value=9;
		//System.out.println(this.search(a, value));
		
		int[] b={1,3,5,7,11,20,30,40};
		
		//System.out.println("二分查找结果："+this.binarySearch(b, 20));
		
		System.out.println("二分查找结果："+this.binarySearchResult(b, 20));
	}
	//冒泡排序
	public void bubbleSort(int[] array){
		for(int i=0;i<array.length-1;i++){
			System.out.print("i:"+i+"----");
			for(int j=0;j<array.length-i-1;j++){
				
				if(array[j]>array[j+1]){
					int temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp; 		 		}
			}
			
			System.out.println("第"+(i+1)+"趟排序");
			
			for(int k=0;k<array.length;k++){
				System.out.print(array[k]+" ");
			}
			
			System.out.println();
		}
		
	}
	
	
	//查找 性能差
	public int search(int[] array,int value){
		for(int i=0;i<array.length;i++){
			if(array[i]==value){
				return i;
			}
		}
		return -1;
	}
	
	//二分查找
	public int binarySearch(int[] array,int value ){
		int low=0;
		int high=array.length-1;
		int middle;
		while(low<=high){
			middle=(low+high)/2;
			if(array[middle]==value){
				return middle;
			}
			
			if(array[middle]>value){
				high=middle-1;
			}
			
			if(array[middle]<value){
				low=middle+1;
			}
			
		}
		
		return -1;
	}
	
	public int binarySearchResult(int[] array,int value ){
		int low=0;
		int high=array.length-1;
		int middle;
		while(low<=high){
			middle=(low+high)/2;
			
			for(int i=0;i<array.length;i++){
				System.out.print(array[i]);
				if(i==middle){
					System.out.print("#");
				}
				
				System.out.print(" ");
				
			}
			
			System.out.println();
			
			if(array[middle]==value){
				return middle;
			}
			
			if(array[middle]>value){
				high=middle-1;
			}
			
			if(array[middle]<value){
				low=middle+1;
			}
			
		}
		
		return -1;
	}
}
