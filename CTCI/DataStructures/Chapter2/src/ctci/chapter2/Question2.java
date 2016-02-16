package ctci.chapter2;

import java.util.Scanner;

import ctci.chapter2.Node;

public class Question2 {
	
	public static void print(Node start){
		Node loop = start;
		while(loop.next!=null){
			System.out.print(loop.data + "->");
			loop = loop.next;
		}
		System.out.print(loop.data);
	}
	
	public static void main(String[] args){
		
		Scanner ip = new Scanner(System.in);		
		int n = ip.nextInt();
		int first = ip.nextInt();
		Node start = new Node(first);
		for(int i=1;i<n;i++){
			int temp = ip.nextInt();
			start.appendToTail(temp);			
		}
		print(start);
		System.out.println();
		System.out.println("-------------------------");
		
		System.out.println("Enter the kth to the last element");
		int k = ip.nextInt();
		
		Node current = start;
		Node current2 = start;
		int t = k;
		while(t > 0){
			current2 = current2.next;
			t--;
		}
		//System.out.println("Current2 is:"+current2.data);
		while(current2.next!=null){
			current = current.next;
			current2 = current2.next;
		}
		
		System.out.println("The node is : " + current.next.data);
	}

}
