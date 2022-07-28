package com.abc.package1;
import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class RemoveConsicutive {
	
	public static ArrayList<Integer> removeConsicutiveDuplicates(int arr[]){
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		System.out.println(arr[0]);
		for(int i=1;i<arr.length; i++) {
			if(arr[i] != arr[i - 1]) {
				result.add(arr[i]);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		int arr[] = {10,10,20,20,30,40,10};
		ArrayList<Integer> arrayList = removeConsicutiveDuplicates(arr);
		
		for(int i : arrayList) {
			System.out.println(i);
		}
		

	}

}
