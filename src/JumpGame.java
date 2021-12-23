
public class JumpGame {

	public static void main(String[] args) {
		int[] nums = {2,3,-1,1,4};
//		int[] nums = {3,2,1,0,4};


		System.out.println(jump(nums));

	}
	
	
	public static boolean jump(int[] nums) {
		return JumpHelper(nums,0);
	}
	
	
	public static boolean JumpHelper(int[] nums, int jPosition) {

		if(jPosition == nums.length-1) return  true;
		else if(jPosition < 0 || jPosition > nums.length-1) return false;
		else {
			int val = nums[jPosition];
			if(val == 0) return  false;
			
			jPosition += val;
			return JumpHelper(nums,jPosition);
		}
		
	}

}
