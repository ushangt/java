
public class Question5 {
	
	public String compression(String ip){
		
		String compressedString = "";
		
		char c[] = ip.toCharArray();
		int count = 1, i=0;
		for(i=0;i<c.length-1;i++){
			if(c[i] == c[i+1]){
				count++;
			}
			else{
				compressedString += String.valueOf(c[i])+count;
				count = 1;
			}				
		}
		compressedString += String.valueOf(c[i])+count;
		if(compressedString.length()>=ip.length())
			return ip;
		else
			return compressedString;
	}
	
	public static void main(String[] args){
		Question5 q = new Question5();
		System.out.println(q.compression("aabcccccaaabbbcccccc"));
	}
	

}
