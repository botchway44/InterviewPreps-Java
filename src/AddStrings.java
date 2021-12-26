/**
 * 
 *Given two non-negative integers, num1 and num2 represented as string, 
 *return the sum of num1 and num2 as a string.
 * You must solve the problem without using any built-in library for handling large integers (such as BigInteger). 
 * You must also not convert the inputs to integers directly.
 */
public class AddStrings {

	public static void main(String[] args) {
//		String num1 = "11", num2 = "123";
		String num1 = "10", num2 = "0";

		//check the length of the smaller string 
		//and append zeros at the beginning
		System.out.println(addStringsHelper(num1,num2));
	}
	
	
	public static String addStringsHelper(String a, String b) {
		
		if(a.length() > b.length()) {
			int difference = a.length() - b.length();
			b = appendZeros(difference, b);
		}else if(b.length() > a.length()) {
			int difference = b.length() - a.length();
			a = appendZeros(difference, a);
		}
		
		return addNumbers(a,b);
	}
	
	
	public static String addNumbers(String a, String b) {
		String total = "";
		int remainder = 0;
		int length = a.length()-1;
		for(int i=0; i<=length; i++) {
			
			int sum = Integer.parseInt(a.charAt(length-i)+"") + Integer.parseInt(b.charAt(length-i)+"") + remainder;
			
			if(sum > 10) {
				remainder = sum /10;
				total =  (sum % 10) + total ;
			}else {
				total = sum +total ;
				remainder = 0;
			}
		}
		
		return total;
	}
	
	public static String appendZeros(int difference, String number) {

		for(int i=0; i<difference; i++) {
			number = "0"+number;
		}

		return number;
	}

}
