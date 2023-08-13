package com;

public class StackUsingArray {

	private int data[];
	private int topIndex;

	public StackUsingArray() {
		data = new int[10];
		topIndex = -1;
	}

	public int size() {
		return topIndex + 1;
	}

//	public void push(int element) {
//		data[++topIndex] = element;
//	}

	// O(1)
	public boolean isEmpty() {

		// if(topIndex==-1) return true;
		// else return false;
		return topIndex == -1;
	}

	// O(1);
	public void push(int elem) throws StackFullException {
		// If stack is full
		if (topIndex == data.length - 1) {
//              StackFullException e= new StackFullException();
//              throw e;
			// Throw Exception
			doubleCapacity();
		}
		topIndex++;
		data[topIndex] = elem;

	}

	private void doubleCapacity() {
		// TODO Auto-generated method stub
		int temp[] = data;
		data = new int[2 * temp.length];
		for (int i = 1; i < temp.length; i++) {
			data[i] = temp[i];
		}

	}

	// O(1)
	public int top() throws StackEmptyException, StackFullException {
		if (topIndex == -1) {
			// Throw stack empty exception
			throw new StackFullException();
		}
		return data[topIndex];

	}

	// O(1)
	public int pop() throws StackEmptyException {

		if (topIndex == -1) {
			throw new StackEmptyException();
		}
		int temp = data[topIndex];
		topIndex--;
		return temp;
	}

}
