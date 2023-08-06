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

	public static void printRecursiveReverse(Node<Integer> head) {
		
		if (head == null) {
			return;
		}
		printRecursiveReverse(head.next);
		System.out.print(head.data + " ");
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

	public static Node<Integer> insertRecursive(Node<Integer> head, int elem, int pos) {
		
		if(head == null && pos > 0) {
			return head;
		}
		
		if (pos == 0) {
			Node<Integer> newNode = new Node<Integer>(elem);
			newNode.next = head;
			return newNode;
		} else {
			
			head.next = insertRecursive(head.next, elem, pos - 1);
			
			return head;
			
		}
	}
	
	public static Node<Integer> deleteNode(Node<Integer> head, int i) {
		if(head==null )
           		return head;
       		if(i==0)
           		return head.next;
       		int count=0;
    		Node<Integer> temp=head;
       		while(temp!=null && count<i-1)
       		{
	           temp=temp.next;
	           count++;
       		}
       		if(temp==null)
           		return head;
       		if(temp.next!=null)
           		temp.next=temp.next.next;
        		return head;
	}

	public static Node<Integer> deleteNodeRecursively(Node<Integer> head, int pos) {
    		if(head==null){
			return head;
		}
            	if(pos==0){
			return head.next;
		}
            			
        	Node<Integer> smallHead = deleteNodeRec(head.next,pos-1);
		head.next = smallHead;
        	return head;
	}

	public static Node<Integer> reverseRecursively(Node<Integer> head) {
		if(head == null || head.next == null ){
			return head;
		}
		Node<Integer> smallHead = reverseRecursively(head.next);
		Node<Integer> tail = smallHead;
		while(tail.next != null){
			tail = tail.next;
		}
		tail.next = head;
		head.next = null;
		return smallHead;

	}

	public static void main(String[] args) {
//		Node<Integer> head = createLinkedList();
//		Node<Integer> head = takeInput();
		Node<Integer> head = takeInputOptimized();
//		printRecursiveReverse(head);
		//		increment(head);
//		print(head);
		head = insert(head, 40, 1);
//		head = deleteNode(head, 1);
		printRecursive(head);
//		int l = length(head);
//		System.out.println(l);

	}

}
