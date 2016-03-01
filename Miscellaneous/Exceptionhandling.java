
public class Exceptionhandling {
	
	public static void main(String args[]){
		System.out.println(new Exceptionhandling().Foo());
	}
	
	String Foo(){
		try{
			throw new Exception("An Exception ");
			//System.out.print("Inside try ");
		}
		catch(Exception e){
			return e.getMessage();
		}
		finally{
			System.out.print("Finally ");
		}
		//return "Outside try ";
	}

}
