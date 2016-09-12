package org.com.cyt.music.impl;

import java.util.Arrays;

public class MathTest {

	public static void test1(){
		int [] arr={12,5,8,22,11,100,78,2};
		
		int temp=0;
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = i+1; j < arr.length; j++) {
				if(arr[j]<arr[i]){
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
				System.err.println(Arrays.toString(arr));
			}
		}
		System.err.println(Arrays.toString(arr));
	}
	
	public static void test2(){
		int [] arr={12,5,8,22,11,100,78,2};
		
		int temp=0;
		for (int i = 0; i < arr.length; i++) {
			
			for (int j =arr.length-1; j >i; j--) {
				if(arr[j]<arr[i]){
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
//				System.err.println(Arrays.toString(arr));
			}
		}
		System.err.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		test2();
	}
}
