import java.util.Scanner;


public class Question4 {

	public static void main(String args[]){
			
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter first string");
		String s1 = ip.nextLine();
		char c[] = s1.toCharArray();
		s1 = s1.trim();
		int n = s1.split(" ").length-1;
		int temp = c.length;
		for(int i=c.length-(n*2);i>=0;i--){
			if(n > 0){
				if(c[i] == ' '){
					c[temp-1] = '0';
					c[temp-2] = '2';
					c[temp-3] = '%';
					temp= temp-3;
					n--;
				}	
				else{
					c[temp-1] = c[i];
					temp = temp-1;
				}
			}				
		}
		System.out.println("Output String is:"+ new String(c));
	}
}
