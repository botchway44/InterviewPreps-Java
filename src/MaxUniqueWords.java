import java.util.HashSet;

public class MaxUniqueWords {

	public static void main(String[] args) {
		String[] arr = {"un", "iq", "ue"};
		String[] arr1 = {"ch", "r", "act", "ers"};
		String[] arr2 = {"abcdefghijklmnopqrstuvwxyz"};

		uniqueWords(arr);
	}
	
	
	private static void uniqueWords(String arr[]) {
		HashSet<String> bagOfWords = new HashSet<String>();
		
		for(int i=0; i<arr.length; i++) {
			bagOfWords.add(arr[i]);
		}
		
		HashSet<String> pairs = new HashSet<>();
		
		//Go through the set and pick the biggest one
		permutationsHelper(bagOfWords, "", pairs );

		for(String word : pairs) {
			System.out.println("PSIRS ::: "+ word);
		}
	}
	
	private static void permutationsHelper(HashSet<String> arr, String prefix,  HashSet<String> pairs){
		System.out.println("Array " + arr + "Prefix "+ prefix);

		
		if(arr.isEmpty()){
//			pairs.add(prefix);
			System.out.println(prefix);
		}
		else if(arr.size() == 1) {
			System.out.println("Prefix ALready >> "+prefix);
			System.out.println("List >> "+pairs);
			
			for(String pair : arr) {
				if(!characterExist(prefix, pair)) {
					prefix += pair;
				}else {
					pairs.add(pair);
				}
			}
			
			pairs.add(prefix);

		}
		else {
			//choose a string
			HashSet<String> unused_pairs = new HashSet<String>();
			for(String pair : arr) {
				if(!characterExist(prefix, pair)) {
					System.out.println("TEMP >> "+pair + " Prefix >> "+ prefix);
					
					//remove all unused pairs from the set
					HashSet<String> temp = new HashSet<String>();
					for(String pp : arr) {
						if(!unused_pairs.contains(pp)) {
							temp.add(pp);
						}
					}
					
					//remove the selected from the pairs again
					temp.remove(pair);

					permutationsHelper(temp, prefix+pair, pairs);	
				}else {
					//remove him from the arr
					unused_pairs.add(pair);
				}
				
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

}
