import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReverseLines {

	private static Scanner scan;
	public static void main(String[] args) throws FileNotFoundException {
		
		scan = new Scanner(new File("file.txt"));
		
		reveseFile(scan);
		
	}
	
	private static void reveseFile(Scanner scan) {
		
		if(scan.hasNextLine()){
			String next  = scan.nextLine();
			reveseFile(scan);
			System.out.println(next);
		}
	}
}
