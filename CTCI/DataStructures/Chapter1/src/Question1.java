public class Question1 {
	
	public static void main(String[] args){
		
		String s = "UNMAOJFSNBYWG";
		char[] c = s.toCharArray();
		boolean flag = false;
		for(int i=0;i<c.length;i++){
			if(s.indexOf(c[i]) == s.lastIndexOf(c[i]))
				flag = true;
			else
				flag = false;
		}
		if(flag)
			System.out.println("Unique characters");
		else
			System.out.println("Not  unique");
	}

}
