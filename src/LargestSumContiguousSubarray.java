public class LargestSumContiguousSubarray {

	public static void main(String[] args) {
		
        int[] nums = {-2, -3, 4, -1, -2, 1, 5, -3, 5,-1,-3,20};
        
		System.out.println(sumSoFar(nums));
	}
	
	public static int sumSoFar(int[] arr) {
	
		int valueSoFar = 0, sumSoFar = 0;
		
		for(int i=0; i<arr.length; i++) {
			valueSoFar += arr[i];
			
			System.out.println("Min So Far >> " + valueSoFar + " SumSoFar >> "+ sumSoFar);
			if(valueSoFar > sumSoFar) sumSoFar = valueSoFar;
			else if(valueSoFar < 0) valueSoFar = 0;
		}
		
		return sumSoFar;
	}
 
	
	

}
