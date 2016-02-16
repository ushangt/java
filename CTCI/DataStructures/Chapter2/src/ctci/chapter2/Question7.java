package ctci.chapter2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Question7 {
	
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
		if(isPalindrome(start))
			System.out.println("Palindrome");
		else
			System.out.println("Not a Palindrome");
					
	}
	
	public static boolean isPalindrome(Node start){
		
		Node current = start;
		ArrayList<Integer> reversed = new ArrayList<Integer>();
		while(current.next != null){
			reversed.add(current.data);
			current = current.next;
		}
		reversed.add(current.data);
		ArrayList<Integer> normal = reversed;
		Collections.reverse(reversed);
		if(reversed.equals(normal))
			return true;
		else
			return false;
		/*Node reverseList = null;
		for(Integer temp : a){
			if(reverseList == null)
				reverseList = new Node(temp);							
			else
				reverseList.appendToTail(temp);
		}*/
		
	}

}
