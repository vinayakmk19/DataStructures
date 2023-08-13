package com;
import java.util.Stack;

public class StackInCollection {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();
		int arr[] = {1,2,3,4,5};
		
		
		for(int elem : arr) {
			stack.push(elem);
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}

}
