import java.util.Stack;

public class ReverseWordsStrings {

	static Stack<String> words = new Stack<>();
	public static void main(String[] args) {
		
		String sen = "This is the worlds view";
		
		//split string into words
		String[] split = sen.split(" ");
		
		for(String word : split) {
			words.push(word);
		}
		
		//Create reversed string from stack
		String builder = "";
		while(!words.isEmpty()) {
			builder+=  words.pop() +" ";
		}
		
		System.out.println(builder);
	}

	
	
}
