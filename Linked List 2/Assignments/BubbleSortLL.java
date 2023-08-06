/*
 * 
 						***** Bubble Sort (Iterative) Linked List *****

	Given a singly linked list of integers, sort it using 'Bubble Sort.'
	Note :
	No need to print the list, it has already been taken care. Only return the new head to the list.
	Input format :
	The first and the only line of each test case or query contains the elements of the singly linked list separated by a single space.
	Remember/Consider :
	While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
	Output format :
	For each test case/query, print the elements of the sorted singly linked list.
	
	Output for every test case will be printed in a seperate line.
	Constraints :
	0 <= M <= 10^3
	Where M is the size of the singly linked list.
	
	Time Limit: 1sec
	Sample Input 1 :
	10 9 8 7 6 5 4 3 -1
	Sample Output 1 :
	 3 4 5 6 7 8 9 10 
	 Sample Input 2 :
	10 -5 9 90 5 67 1 89 -1
	Sample Output 2 :
	-5 1 5 9 10 67 89 90 


 */

package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution6 {
	private static int length(Node<Integer> head) {
		int count = 0;
		while (head != null) {
			head = head.next;
			count++;
		}
		return count;
	}

	public static Node<Integer> bubbleSort(Node<Integer> head) {
		int n = length(head);
		for (int i = 0; i < (n - 1); i++) {
			Node<Integer> prev = null;
			Node<Integer> curr = head;
			for (int j = 0; j < (n - i - 1); j++) {
				if (curr.data <= curr.next.data) {
					prev = curr;
					curr = curr.next;
				} else {
					if (prev == null) {
						Node<Integer> fwd = curr.next;
						head = head.next;
						curr.next = fwd.next;
						fwd.next = curr;
						prev = fwd;
					} else {
						Node<Integer> fwd = curr.next;
						prev.next = fwd;
						curr.next = fwd.next;
						fwd.next = curr;
						prev = fwd;
					}
				}
			}
		}
		return head;
	}
}

public class BubbleSortLL {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static Node<Integer> takeInput() throws IOException {
		Node<Integer> head = null, tail = null;

		String[] datas = br.readLine().trim().split("\\s");

		int i = 0;
		while (i < datas.length && !datas[i].equals("-1")) {
			int data = Integer.parseInt(datas[i]);
			Node<Integer> newNode = new Node<Integer>(data);
			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = newNode;
			}
			i += 1;
		}

		return head;
	}

	public static void print(Node<Integer> head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}

		System.out.println();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Node<Integer> head = takeInput();

		head = Solution6.bubbleSort(head);
		print(head);
	}
}
