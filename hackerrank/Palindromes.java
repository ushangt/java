package com.zappos.interview;

import java.io.*;
import java.util.*;

public class Palindromes {
	
	static Set<String> setOfPalindromes = new HashSet<>();

    /* Logic Used:
       Start expanding even length and odd length palindromes across potential middle character.
       Expansion: We start from the extreme ends and traverse through the middle of the string and compare each
                  front character with the back character to see if they are the same. If same throughout it means 
                  the word is a palindrome and we add it to the setOfPalindromes set.
       We continue doing this till we reach the end of the string.
       Since we use set it will not allow any duplicates to be added. And we get only the unique palindromes at the end.
       Advantage/Optimization: If string doesn't have any/many palindromes the complexity will be just single iteration
       ie 0(n). 
    */

    /** This method is used to send the even and odd palindromes to expansion function as stated in the logic above**/
    static int palindrome(String str) {
        		
		for(int i=0; i<str.length(); i++){
            //Expanding even length palindromes
            expandPalindromes(str, i, i+1);
            //Expanding odd length palindromes
            expandPalindromes(str, i, i);
        }
        return setOfPalindromes.size();
    }

    /** This method is used to expand the palindromes as stated in the logic above**/
    static void expandPalindromes(String s, int i, int j ){
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
	            setOfPalindromes.add(s.substring(i,j+1));
	            i--; 
                j++;
	     }
	}

	public static void main(String[] args) throws IOException{
	    Scanner in = new Scanner(System.in);
	    final String fileName = System.getenv("OUTPUT_PATH");
	    BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
	    int res;
	    String _str;
	    try {
	        _str = in.nextLine();
	    } catch (Exception e) {
	        _str = null;
	    }
	    
	    res = palindrome(_str);
	    bw.write(String.valueOf(res));
	    bw.newLine();
	    
	    bw.close();
	}
}


/*

static int palindrome(String str) {
char[] charArray = str.toCharArray();
Set<String> setOfPalindromes = new HashSet<>();
String checkPalindromeString = "";
for(int i =0;i<charArray.length;i++){
	checkPalindromeString = charArray[i]+"";
    setOfPalindromes.add(checkPalindromeString);
	for(int j=i+1;j<charArray.length;j++){
		checkPalindromeString += charArray[j];
		if(checkIfPalindrome(checkPalindromeString))
			setOfPalindromes.add(checkPalindromeString);
	}
}

return setOfPalindromes.size();

}


static boolean checkIfPalindrome(String s){
if(s.equals(new StringBuilder(s).reverse().toString()))
	return true;
return false;
}

*/