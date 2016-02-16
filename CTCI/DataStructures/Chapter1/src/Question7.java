
public class Question7 {
	
	public static void main(String args[]){
		int m=4, n=3;
		int x[][] = new int[m][n];
		int rows[] = new int[m];
		int columns[] = new int[n];
		x[1][3] = 0;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(x[i][j] == 0){
					rows[i] = 1;
					columns[j] = 1;
				}
			}
		}
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(rows[i] == 1 || columns[j] == 1)
					x[i][j] = 0;
			}
		}
		
		System.out.println(x);
	}

}
