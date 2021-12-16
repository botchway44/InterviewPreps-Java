import java.util.HashSet;

public class StringCombinations {

	public static void main(String[] args) {
		combinations("ab");
	}

	
	private static void combinations(String word) {
		HashSet<String> combinations  = new HashSet<>();
		
		combinationsHelper(word, "", combinations);
		
		System.out.println(combinations);
		System.out.println(combinations.size());

	}
	
	
	private static void combinationsHelper(String word,String prefix, HashSet<String> combinations) {
		
		if(word.length() <= 0 ) {
			System.out.println("Prefix >> "+ prefix);
			combinations.add(prefix);
		}
		
		for(int i=0; i<word.length(); i++ ) {
			String chosen = word.charAt(i)+"";
			String rem = word.substring(i+1);
			System.out.println("Chosen >> "+ chosen + " Rem >> "+ rem);
			combinationsHelper(rem, prefix, combinations);
			combinationsHelper(rem, prefix+chosen, combinations);

		}
			 
	}
}
