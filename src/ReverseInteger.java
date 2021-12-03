
public class ReverseInteger {

	
	public static void main(String[] args) {
		
		System.out.println("Lets Get started");
		
		int num = 102;
		String reversed = "";
		
		
		//store the number temporarily
		int temp = num;
		//store the 
		
		while(temp > 0) {
			int remainder = temp % 10;
			temp = temp / 10;
			
			reversed = reversed + remainder;
			
			System.out.println(reversed);
		}
		
		System.out.println("Reversed String : "+ reversed);
	}
}
