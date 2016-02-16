package ctci.chapter2;

import java.util.ArrayList;
import java.util.Scanner;

import ctci.chapter2.Node;

public class Question1 {
	
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
		
		ArrayList<Integer> cal = new ArrayList<>();
		Node l = start;
		while(l.next!=null){
			if(cal.contains(l.data))
				start.deleteNode(start, l.data);
			else
				cal.add(l.data);
			l = l.next;
		}
		print(start);
		
		System.out.println();
		System.out.println("-------------------------");
		start.appendToTail(5);
		Node current = start;
		while(current != null){
			Node temp = current;
			while(temp.next != null){
				if(temp.next.data == current.data)
					temp.next = temp.next.next;
				else
					temp = temp.next;												
			}
			current = current.next;
		}
		
		print(start);
		
	}

}
