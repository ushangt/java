public class Question2 {
	
	public String reverse(String s){
		
		char[] c = s.toCharArray();
		String ans = "";
		for(int i=c.length-1; i>=0; i--){
			ans+=c[i];
		}
		
		return ans;
		
	}
	
	public static void main(String[] args){
		
		Question2 q2= new Question2();
		System.out.println("Output is:" + q2.reverse("ABCDEFGH"));
		
	}

}
