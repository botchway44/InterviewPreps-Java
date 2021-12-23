import java.util.HashSet;

public class FirstMissingPositive {

	public static void main(String[] args) {
		
		int[] arr = {7,8,9,11,12};
//		int[] arr = {3,4,-1,1};

		System.out.println(missingPositive(arr));
		System.out.println(smallesMissingPositive(arr));

	}
	
	
	//big O(N) and big O(N) space
	public static int missingPositive(int[] arr){
		int smallest = 1;
		HashSet<Integer> seen = new HashSet<>();
		
		for(int i=0; i<arr.length; i++) {
			int currentValue = arr[i];
			//add current value to set
			seen.add(currentValue);
			
			if(seen.contains(smallest)) {
				smallest++;
			}
		}
		
		
		return smallest;
	}
	
	//big O(N) and big O(1) space
	public static int smallesMissingPositive(int[] arr){
		
		printArray(arr);

		for(int i=0; i<arr.length; i++) {
			int currentValue = arr[i]-1;

			//swap the values their corresponding position in the array
			while( arr[i] >=0 && arr[i] < arr.length && arr[i] != arr[currentValue]) {
				System.out.println("Hello >> " + currentValue);

				int temp = arr[i];
				arr[i] = currentValue+1;
				arr[currentValue] = temp;
				currentValue = arr[i]-1;
			
				printArray(arr);
			}

			System.out.println("------------------------------");

			printArray(arr);

			
		}
		
		
		for(int i=0; i<arr.length; i++) {
			if(i+1 != arr[i]) return i+1;
		}
		
		return arr.length;
	}

	
	public static void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] +" ");
		}
		
		System.out.println();
	}
	
}
