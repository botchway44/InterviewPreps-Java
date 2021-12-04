
public class Task1 {

	public static void main(String[] args) {

		int[] nums = {1, 2, 2, 3};
		
		for(int i=0; i<nums.length; i++) {
			int count = 1;
			for(int j=0; j< nums.length; j++) {
				if(nums[i] == nums[j] && i!=j) {
					count++;
				}
				
				
			}
			if(count > 2 || count <= 1) {System.out.println("Found more for >> "+ nums[i] + " >> " +count);}
			else {
				System.out.println("Found les for >> "+ i + " >> "+ count);
			}
		}
	}

}
