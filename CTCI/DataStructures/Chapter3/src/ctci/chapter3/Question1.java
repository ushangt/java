package ctci.chapter3;

public class Question1 {
	
	public class Stack{
		
		int n = 100;
		int totalSize = n * 3;
		int stack[] = new int[totalSize];
		int stackPointer[] = {-1, -1, -1};
		/*int stack1Pointer = 0;
		int stack2Pointer = totalSize/3;
		int stack3Pointer = 2*totalSize/3;*/
		
		void push(int stackNumber, int value) throws Exception{
			if(stackPointer[stackNumber] + 1 >= n){
				throw new Exception("Out of Space");
			}
			stackPointer[stackNumber]++;
			stack[topOfStack(stackNumber)] = value;
		}
		
		int topOfStack(int stackNumber){
			return stackNumber * n + stackPointer[stackNumber];
		}
		
		int pop(int stackNumber) throws Exception{
			if(stackPointer[stackNumber] == -1){
				throw new Exception("No elements");
			}
			int value = stack[topOfStack(stackNumber)];
			stack[topOfStack(stackNumber)] = 0;
			stackPointer[stackNumber]--;
			return value;
		}
		
		int peek(int stackNumber){
			return stack[topOfStack(stackNumber)];
		}
		
		boolean isEmpty(int stackNumber){
			return stackPointer[stackNumber] == -1;
		}
	}

}
