package ctci.chapter2;

import java.util.Scanner;

public class Question3 {
	
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
		
		
		print(start);
		
	}
	
	public static void deleteCenterNode(Node n){
		
		Node temp = n.next;
		n.data = temp.data;
		n.next = temp.next;
	}

}
