import java.util.HashSet;

public class SmallestPositiveInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] raw_nums = {1, 2, 3};
//		[1, 2, 3]
		HashSet<Integer> nums = new HashSet<Integer>();
		
		for(int i=0; i<raw_nums.length; i++) {
			nums.add(raw_nums[i]);
		}
		
		int smallest = 1;
		int lenght = nums.size();
		while(true) {
			if(!nums.contains(smallest)) {
				System.out.println("Smallest is >> "+ smallest);
				break;
			}else {
				smallest++;
				
			}
		}
		
		if(smallest == Integer.MIN_VALUE) {
			smallest = nums.size()+1;
		}
		
		System.out.println(smallest);
		
	}

}
