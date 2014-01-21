import java.util.*;
import java.io.*;


public class ReverseWords {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner input = new Scanner(new File("/home/jordan/workspace/code jam/src/ReverseWords.in"));
		
		run(input);
		
	}
	
	public static void run(Scanner input) throws FileNotFoundException {
		
		PrintStream pStream = new PrintStream(new File("/home/jordan/workspace/code jam/src/ReverseWords.out"));
		
		input.nextLine();
		
		int currentCase = 0;
		
		while(input.hasNextLine()) {
			currentCase++;
			String line = input.nextLine();
			Scanner readLine = new Scanner(line);
			Stack<String> words = new Stack(); 
			while(readLine.hasNext()) {
				words.push(readLine.next());
			}
			String output = "Case #" + currentCase + ":";
			while(!words.isEmpty()) {
				output = output + " " + words.pop();
			}
			pStream.println(output);
		}
	}
	
}
