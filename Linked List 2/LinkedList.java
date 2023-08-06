package com.abc;

import java.util.Scanner;

class Node<T> {
	T data;
	Node<T> next;

	Node(T data) {
		this.data = data;
	}

}

class DoubleNode {
	Node<Integer> head;
	Node<Integer> tail;

	DoubleNode() {

	}

	DoubleNode(Node<Integer> head, Node<Integer> tail) {
		this.head = head;
		this.tail = tail;
	}
}

public class LinkedList {

	public static Node<Integer> takeInputOptimized() {

		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		Node<Integer> head = null, tail = null;
		while (data != -1) {
			Node<Integer> currentNode = new Node<Integer>(data);
			if (head == null) {

				head = currentNode;
				tail = currentNode;

			} else {

				tail.next = currentNode;
				tail = currentNode;

			}
			data = s.nextInt();
		}
		return head;
	}

	public static void printRecursive(Node<Integer> head) {

		if (head == null) {
			return;
		}
		System.out.print(head.data + " ");
		printRecursive(head.next);
	}

	public static DoubleNode reverseOptimized(Node<Integer> head) {
		DoubleNode ans;
		if (head == null || head.next == null) {
			ans = new DoubleNode(head, head);
			ans.head = head;
			ans.tail = head;
			return ans;
		}

		DoubleNode smallans = reverseOptimized(head.next);
		smallans.tail.next = head;
		head.next = null;
		ans = new DoubleNode();
		ans.head = smallans.head;
		ans.tail = head;
		return ans;
	}

	public static Node<Integer> reverseHelper(Node<Integer> head) {
		DoubleNode ans = reverseOptimized(head);
		return ans.head;
	}

	public static Node<Integer> reverseBest(Node<Integer> head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node<Integer> smallHead = reverseBest(head.next);
		Node<Integer> reversedTail = head.next;
		reversedTail.next = head;
		head.next = null;
		return smallHead;
	}

	public static Node<Integer> midPoint(Node<Integer> head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node<Integer> slow = head;
		Node<Integer> fast = head.next;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;

	}

	public static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2) {

		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}

		Node<Integer> t1 = head1;
		Node<Integer> t2 = head2;

		Node<Integer> head = null;
		Node<Integer> tail = null;

		if (t1.data <= t2.data) {
			head = t1;
			tail = t1;
			t1 = t1.next;
		} else {
			head = t2;
			tail = t2;
			t2 = t2.next;
		}

		while (t1 != null && t2 != null) {
			if (t1.data <= t2.data) {
				tail.next = t1;
				tail = t1;
				t1 = t1.next;
			} else {
				tail.next = t2;
				tail = t2;
				t2 = t2.next;
			}
		}

		if (t1 != null) {
			tail.next = t1;
		} else {
			tail.next = t2;
		}

		return head;

	}

	public static void main(String[] args) {
		
		Node head1 = takeInputOptimized();
		Node head2 = takeInputOptimized();
		Node ans = merge(head1, head2);
		

//		head = reverseHelper(head);
//		head = reverseBest(head);
//		Node<Integer> mid = midPoint(head);
//		System.out.println(mid.data);
		printRecursive(ans);
	}

}
