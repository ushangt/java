
public class Question6 {
	
	public void rotation(int matrix[][], int n){
		
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;
			for(int i = first; i< last; ++i){
				int offset = i - first;
				
				//Top
				int top = matrix[first][i];
				
				// Left to top
				matrix[first][i] = matrix[last-offset][first];
				
				// Bottom to left
				matrix[last-offset][first] = matrix[last][last-offset];
				
				// Right to Bottom
				matrix[last][last - offset] = matrix[i][last];
				
				//Top to Right
				matrix[i][last] = top;
				
			}
		}
		
	}
	
	public static void main(String args[]){
		
	}

}
