
public class MaximunDepth {

	private static int lengthCounter = 0;
	public static void main(String[] args) {

		//We can use an object in java or have s simple node interface
		// to solve it
		Object[] root = {3,9,20,null,null,15,7};
		countNode(root);
		
	}
	
	
	private static void countNode(Object[] list) {
		
		//pick the node and init counter
		countNodeHelper(list, 0, 0);
		System.out.println("Length  = "+ lengthCounter);
	}

	private static void countNodeHelper(Object[] list, int position, int length ) {
		if(position < list.length && list[position] != null) {
			//get current node element
			Object parentNode = list[position];
			System.out.println("Parent node is "+parentNode);
			
			//count the left tree 
			countNodeHelper(list, (2*position)+1, length+1);
			

			//count the right tree 
			countNodeHelper(list, (2*position)+2, length+1);
			
			System.out.println("-------------------------------------------");

		}
		
		//Print and stop there
		else{
			
			Object parent = list[(position -1)/2];
			System.out.println("Ended. Parent = "+ parent + " Length = " + length );
			
			//verify if the global length count is greater
			if(length > lengthCounter ) {
				lengthCounter = length;
			}
		}
	}
}
