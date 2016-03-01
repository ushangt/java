class Stack{
	
	private int a[];
	private int top = -1;
	
	Stack(){
		a = new int[5];
	}
	
	Stack(int n){
		a = new int[n];
	}
	
	void push(int n){
		if(top == a.length - 1)
			System.out.println("Stack is full");
		else
			a[++top] = n;
	}
	
	int pop(){
		if(top == -1){
			System.out.println("Stack is empty");
			return -1;
		}
		else{
			return a[top--];
		}
	}
	
	int max(){
		int max = 0;
		
		for(int i=0;i<a.length;i++){
			if(a[i] > max)
				max = a[i];
		}
		
		return max;
	}
	
}


public class LargestStack {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack s = new Stack();
		s.push(57);
		s.push(36);
		s.push(21);
		s.push(1);
		s.push(7);		
		System.out.println(s.max());

	}

}
