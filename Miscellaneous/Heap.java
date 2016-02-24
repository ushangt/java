import java.util.Scanner;


public class Heap {
	
	int a[];
	int index = -1;
	
	Heap(){
		a = new int[10];
	}
	
	Heap(int n){
		a = new int[n];
	}
	
	void insert(int v){
		if(a.length-1 == index)
			System.out.println("Heap is full");
		else{
			int i = 0;
			for(i= ++index; i>0 && a[(i-1)/2]>v; i= (i-1)/2){
				a[i] = a[(i-1)/2];				
			}		
			a[i] = v;
		}
	}
	
	int delete(){
		if(index == -1){
			System.out.println("Heap is empty");
			return -1;
		}			
		else{
			int v = a[0];
			int t = a[index--];
			int i =1;
			for(i=1; i<=index; i=2*i + 1){
				if(a[i]>a[i+1] && (i+1) <= index)
					i++;
				if(a[i]<t)
					a[(i-1)/2] = a[i];
				else
					break;
			}
			a[(i-1)/2] = t;
			return v;
		}			
	}
	
	boolean empty(){
		if(index == -1)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 0;
		System.out.println("Enter no.of elements");
		Scanner ip = new Scanner(System.in);
		n=ip.nextInt();
		Heap s = new Heap(n);
		for(int i=0 ;i<n; i++){
			System.out.println("Enter "+i+" th element:");
			int x = ip.nextInt();
			s.insert(x);
		}
		while(!s.empty()){
			System.out.println(s.delete());
		}
	}

}
