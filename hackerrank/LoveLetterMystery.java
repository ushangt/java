import java.util.Scanner;

public class LoveLetterMystery {
	
	static void mystery(String[] letter) {

        for(int i=0; i<letter.length; i++){
            //Take the current string and convert it a character array
			char[] c = letter[i].toCharArray();
            // Store the total changes made to the characters in this variable
			int totalChanges = 0;
            /* We can find the total changes required in the string by subtracting among the ASCII values
               of the first half of the string to the corresponding second half ie.
               If we divide a palindrome into two parts from its center we know that it is symmetrical.
               Thus, we start moving in two directions towards the center. 
               J moves from starting of the array while K moves from the end of the array.
               While moving we add the differences between the letters from the first (left of center) half of the string
               and its symmetrical index on the second half(right of center)
            */
			for(int j=0,k=c.length-1; j<k; j++,k--){
				if(c[j] < c[k])
					totalChanges += c[k] - c[j];
				else
					totalChanges += c[j] - c[k];
					
			}
			
			System.out.println(totalChanges);
		}

    }
	
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int _letter_size = 0;
        _letter_size = Integer.parseInt(in.nextLine());
        String[] _letter = new String[_letter_size];
        String _letter_item;
        for(int _letter_i = 0; _letter_i < _letter_size; _letter_i++) {
            try {
                _letter_item = in.nextLine();
            } catch (Exception e) {
                _letter_item = null;
            }
            _letter[_letter_i] = _letter_item;
        }
        
        mystery(_letter);
        
    }

}
