import java.util.HashSet;

public class RemoveDuplicates {

	
	public static void main(String[] args) {
		int[] nums =  {0,0,1,1,1,2,2,3,3,4};
		
		HashSet<Integer> sortednums = new HashSet<Integer>();
		
		for(int num : nums) {
			sortednums.add(num);
		}
		
		for(int num : sortednums) {
			System.out.print(num);
		}
	}
}
