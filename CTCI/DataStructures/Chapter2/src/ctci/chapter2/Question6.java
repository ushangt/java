package ctci.chapter2;

import java.util.Scanner;

public class Question6 {
	
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
					
	}
	
	public static Node loopBeginningNode(Node start){
		
		Node slow = start;
		Node fast = start;
		
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow == fast)
				break;
		}
		
		if(fast == null || fast.next == null)
			return null;
		
		slow = start;
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		
		return fast;
		
	}
	
	

}
