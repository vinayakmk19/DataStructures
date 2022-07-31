package com.abc.pack;

import java.util.Scanner;

public class LinkedListUse {

	public static Node<Integer> createLinkedList() {
		Node<Integer> n1 = new Node<>(10);
		Node<Integer> n2 = new Node<>(20);
		Node<Integer> n3 = new Node<>(30);
		Node<Integer> n4 = new Node<>(40);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		return n1;
	}

	public static void increment(Node<Integer> head) {
		head.data++;
	}

	public static void print(Node<Integer> head) {
		Node<Integer> temp = head;
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void printRecursive(Node<Integer> head) {

		if (head == null) {
			return;
		}
		System.out.print(head.data + " ");
		printRecursive(head.next);
	}

	public static int length(Node<Integer> head) {
		int l = 0;
		while (head != null) {
			l++;
			head = head.next;
		}
		return l;

	}

	public static Node<Integer> takeInput() {

		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		Node<Integer> head = null;
		while (data != -1) {
			Node<Integer> currentNode = new Node<Integer>(data);
			if (head == null) {
				head = currentNode;

			} else {
				Node<Integer> tail = head;
				while (tail.next != null) {
					tail = tail.next;
				}

				tail.next = currentNode;

			}
			data = s.nextInt();
		}
		return head;
	}

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

	public static Node<Integer> insert(Node<Integer> head, int elem, int pos) {
		Node<Integer> nodeToBeInserted = new Node<Integer>(elem);

		if (pos == 0) {
			nodeToBeInserted.next = head;
			return nodeToBeInserted;
		} else {
			int count = 0;
			Node<Integer> prev = head;
			while (count < pos - 1 && prev != null) {
				count++;
				prev = prev.next;
			}
			if(prev != null) {
				nodeToBeInserted.next = prev.next;
				prev.next = nodeToBeInserted;
			}
			return head;

		}
	}

	public static void main(String[] args) {
//		Node<Integer> head = createLinkedList();
//		Node<Integer> head = takeInput();
		Node<Integer> head = takeInputOptimized();
//		increment(head);
//		print(head);
		head = insert(head, 40, 1);
		printRecursive(head);
//		int l = length(head);
//		System.out.println(l);

	}

}
