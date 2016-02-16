import java.util.Arrays;
import java.util.Scanner;


public class Question3 {
	
	public static void main(String args[]){
		
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter first string");
		String s1 = ip.next();
		System.out.println("Enter second string");
		String s2 = ip.next();
		if(s1.length() != s2.length()){
			System.out.println("Not permutation");
		}
		char c1[] = s1.toCharArray();
		char c2[] = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		
		if(Arrays.equals(c1, c2))
			System.out.println("In permutation");
		else
			System.out.println("Not permutation");
		
		
		
	}

}
