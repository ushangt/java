import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class OddElements {
	
	public static void main(String args[]){
		
		int a[] = {10,20,30,40,50,10,10,30,40,30};
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		for(int i=0;i<a.length;i++){
			if(h.containsKey(a[i])){
				int count = (int) h.get(a[i]);
				count++;
				h.put(a[i], count);
			}
			else{
				h.put(a[i], 1);
			}
		}
		Iterator it = h.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();	        
	       if((int)pair.getValue() % 2 != 0){
	        	System.out.println(pair.getKey());
	        }       
	    }
		
		
	}

}
