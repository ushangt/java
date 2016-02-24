import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class FileReadWrite {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("wordlist.txt"));
		try {
			String str="";
			int counter = 0;
		    PrintWriter writer = new PrintWriter("nine-letter-words.txt", "UTF-8");
		    while ((str = br.readLine()) != null) {
		        if(str.length() == 9){
		        	writer.println(str);
		        	counter++;
		        }
		    }
		    writer.close();
		    System.out.println("Count is:"+counter);
		} finally {
		    br.close();
		}

	}

}
