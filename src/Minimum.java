
import java.util.*;
public class Minimum {

	public static void main(String[] args) {
		  
//		A = [
		int N= 10;
		Random rand = new Random();
		
//		int[] nums = new int[20];
		ArrayList<Integer> nums = new ArrayList<>();
		
		//Generate random numbers
		for(int i=0; i< N; i++){
	       nums.add(rand.nextInt());
	       }
		
		nums.toArray();
	}
}
