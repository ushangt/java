package ctci.chapter2;

import java.util.Scanner;

public class Question4 {
	
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
		
		System.out.println("Enter the value of x");
		int x = ip.nextInt();
		print(arrangeInOrder(x, start));
		
	}
	
	public static Node arrangeInOrder(int x, Node start){
		Node lessThenX = null;
		Node greaterThenX = null;
		Node lessThenPointer = null;
		Node greaterThenPointer = null;
		Node node = start;
		while(node!=null){
			Node next = node.next;
			node.next = null;
			if(node.data > x){
				if(greaterThenX == null){
					greaterThenX = node;
					greaterThenPointer = greaterThenX;
					//System.out.println("1st if:"+node.data);
				}
				else{
					greaterThenX.next = node;	
					greaterThenPointer = node;
					//System.out.println("1st else:"+node.data);
				}
			}							
			else{
				if(lessThenX == null){
					lessThenX = node;
					lessThenPointer = lessThenX;
					//System.out.println("2nd if:"+node.data);
				}					
				else{
					lessThenX.next = node;
					lessThenPointer = node;		
					//System.out.println("2nd else:"+node.data);
				}										
			}							
			node = next;
		}
		
		
		lessThenPointer.next = greaterThenX;
		return lessThenX;
					
	}

}
