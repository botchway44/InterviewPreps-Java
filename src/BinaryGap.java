import java.util.Stack;

public class BinaryGap {

	public static void main(String[] args) {
			int num = 1041;
			
			
			System.out.println(binaryGap("10010001010_2"));
			System.out.println(binaryGap(printBinary(529)));
			System.out.println(binaryGap(printBinary(32)));

			System.out.println(binaryGap(printBinary(15)));

	}
	
	
	private static String printBinary(int num) {
		if(num < 1) return num+"";
		
		else {
			int remainder = num % 2;
			int tempNum = num / 2;
			return printBinary(tempNum) +"" +remainder ;
		}
	}
	
	private static int binaryGap(String binaryForm) {
		
		int highest = 0;
		int count = 0;
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i< binaryForm.length(); i++) {
			if(binaryForm.charAt(i) == '0') {
				count+=1;
			}else if(binaryForm.charAt(i) == '1') {
				
				if(!stack.isEmpty()) {
					stack.pop();
					//set the current highest to the current count
					if(count > highest) highest = count;
					stack.push('1');
					count  = 0;

				}else {
					stack.push('1');
					//set count to 0
					count  = 0;
				}
				
			}
		}
				
		return highest;
	}

}
