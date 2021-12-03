import java.util.HashMap;
import java.util.HashSet;

public class Fibonacci {

	static HashMap<Integer, Integer>  fibPairs = new HashMap<>();
	public static void main(String[] args) {
		
		for(int i=0; i< 20; i++) {
			
			int fib = fibHelper(i);
			
			System.out.println(fib + " ");
		}
	}
	
	
	private static int fibHelper(int number) {
		if( number <= 2) return 1;
		//check if fib already exist
		else if(fibPairs.containsKey(number)) {
			return fibPairs.get(number);
		}
		else {
			//Implement memiozation
			int result = (fibHelper(number - 1) + fibHelper(number - 2));
			fibPairs.put(number, result);
			return result;
		}
	}
	
	
	
}
