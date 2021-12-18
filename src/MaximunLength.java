import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class MaximunLength {

	public static void main(String[] args) {
		
		String[] arr = {"un","iq", "ue"};
		PriorityQueue<String> words = new PriorityQueue<String>( new Comparator<String>(){
			public int compare(String a1, String a2) {
				return a1.length() > a2.length() ? -1 : 1;
				
			}
		});
		
//		PriorityQueue<String> words = new PriorityQueue<String>(Comparator.comparing(String::length));
		
		for(int i=0; i< arr.length; i++) {
			//pick a string in ith position
			String starting = arr[i];
			words.add(starting);

			//run through the starting location to the 
			for(int j=i+1; j<arr.length; j++) {
				String temp = arr[j];
				if(!characterExist(starting,temp)) {
					words.add(starting+temp);
				}
			}
		}
		
		System.out.println(words);
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
