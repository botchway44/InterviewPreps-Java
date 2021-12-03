import java.util.HashSet;
import java.util.Set;

public class PrintBinary {

	public static void main(String[] args) {
		
		
		int num = 4;
//		System.out.println(printBinary(4));
		
		
//		printBinaryDigits(2,"");
//		printDecimalDigits(5,"");
		permuteString("HII", "");
	}
	
	
	private static String printBinary(int num) {
		if(num < 1) return num+"";
		
		else {
			int remainder = num % 2;
			int tempNum = num / 2;
			return printBinary(tempNum) +"" +remainder ;
		}
	}
	
	
	private static void printBinaryDigits(int number, String prefix) {
		if(number == 0) {

			System.out.println(prefix);
		}else {
			printBinaryDigits(number - 1, prefix + "0");
			printBinaryDigits(number - 1, prefix + "1");

		}
	}
	
	private static void printDecimalDigits(int number, String prefix) {
		if(number == 0) {

			System.out.println(prefix);
		}else {
			
			for(int i=0; i<10; i++) {
				printDecimalDigits(number - 1, prefix + i);
			}
		}
	}
	
	static HashSet<String> permutations = new HashSet<>();

	private static void permuteString(String word, String prefix) {
		if(word.length() == 0) {

			System.out.println("Actual Permuation >>> "+prefix);
			permutations.add(prefix);
		}else {
			
			for(int i=0; i<word.length(); i++) {
				char ch = word.charAt(i);
				System.out.println("CH >> " + ch);
				String s2 = word.substring(0,i) + word.substring(i+1);
				System.out.println("STRING >> "+ s2);
				permuteString(s2, prefix + ch);
			}
		}
	}
}
