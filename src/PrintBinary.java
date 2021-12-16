import java.util.HashSet;
import java.util.Set;

public class PrintBinary {

	public static void main(String[] args) {
		
		
		int num = 4;
//		System.out.println(printBinary(4));
		
		
//		printBinaryDigits(2,"");
//		printDecimalDigits(5,"");
		permuteString("world", "");
		System.out.println(permutations.size());
		
//		 HashSet<String> newperms = new HashSet<>();
//
//		for(String pair : permutations) {
//			for(String second : permutations) {
//				if(!characterExist(pair,second)) {
//					newperms.add(second);
//				}else {
//					newperms.add(second);
//				}
//			}
//		}
//		System.out.println(newperms);

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
		System.out.println("Prefix >> "+ prefix + " Word >> "+ word);

		if(word.length() == 0) {
			permutations.add(prefix);
		}else {
			
			for(int i=0; i<word.length(); i++) {
				char ch = word.charAt(i);
				String s2 = word.substring(0,i) + word.substring(i+1);
				System.out.println("Rem >> "+ s2);
				permuteString(s2, prefix + ch);
			}
		}
	}
	
	private static boolean characterExist(String one, String two) {
		HashSet<Character>  temp  = new HashSet<Character>();
		for(int i=0; i< two.length(); i++) {
			temp.add(two.charAt(i));
		}
		
		for(int i=0; i<one.length(); i++) {
			if(temp.contains(one.charAt(i))) return true;
		}
		
		return false;
	}
	
	private static boolean unique(String one, String two) {
		HashSet<Character>  temp_one  = new HashSet<Character>();
		for(int i=0; i< one.length(); i++) {
			temp_one.add(one.charAt(i));
		}
		
		HashSet<Character>  temp_two  = new HashSet<Character>();
		for(int i=0; i< two.length(); i++) {
			temp_two.add(two.charAt(i));
		}
		
		for(Character pair : temp_one) {
			if(temp_two.contains(pair)) return false;
		}
		
		return true;
	}
}
