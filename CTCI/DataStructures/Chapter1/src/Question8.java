
public class Question8 {
	
	public boolean isSubstring(String s1, String s2){
		return false;
	}
	
	public boolean rotation(String s1, String s2){
		
		if(s1.length() == s2.length() && s1.length() > 0){
			String x = s1 + s1;
			return isSubstring(x,s2);
		}
		
		return false;
		
	}

}
