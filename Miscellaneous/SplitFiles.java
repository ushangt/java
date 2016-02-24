
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class SplitFiles {
	
	public static void splitFile(File f) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("wordlist.txt"));
		ArrayList<ArrayList<String>> listOfLists = new ArrayList<ArrayList<String>>();
		for(int i=0;i<26;i++){
			listOfLists.add(new ArrayList<String>());
		}
		try {
			String str="";
			
		    
		    
		    while ((str = br.readLine()) != null) {
		    			        
		    	if(str.length() == 9){
		    		listOfLists.get(str.toLowerCase().charAt(0)-97).add(str.toLowerCase());
			        System.out.println(str);
		    	}
		        
		    }
		    
		    
		} finally {
		    br.close();
		}
		
		for(int i=0;i<26;i++){
			char alphabetic = (char)(i+97);
			String fileName = Character.toString(alphabetic);
			PrintWriter writer = new PrintWriter(fileName+".txt", "UTF-8");
			for(String s : listOfLists.get(i)){
				writer.println(s);
			}
			writer.close();
		}
    }

    public static void main(String[] args) throws IOException {
        splitFile(new File("nine-letter-words.txt"));
    }

}
