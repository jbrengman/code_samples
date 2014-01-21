
import java.util.*;
import java.io.*;


public class AlienLanguage {

	public static void main(String[] args) throws FileNotFoundException {
		
		
		Scanner readLines = new Scanner(new File("input.in"));
		String getVars = readLines.nextLine();
		
		Scanner readInts = new Scanner(getVars);
		int l = readInts.nextInt(); // tokens or letters in each word
		int d = readInts.nextInt(); // number of known words, number of lines to read into dictionary
		int n = readInts.nextInt(); // number of test cases
		
		HashSet<String> dictionary = createDict(readLines, d);
		
		List<List<List<Character>>> tests = createTestList(readLines, n);
		
		checkAndPrint(dictionary, tests, l);
				
		//System.out.println(tests);
		
	}
	
	public static HashSet<String> createDict(Scanner readLines, int d){
		HashSet<String> dictionary = new HashSet<String>();
		for (int i = 0; i < d; i++){
			String line = readLines.nextLine();
			dictionary.add(line);
		}
		return dictionary;
	}
	
	public static List<List<List<Character>>> createTestList(Scanner readLines, int n){
		List<List<List<Character>>> tests = new LinkedList<List<List<Character>>>();
		for (int i = 0; i < n; i++){
			LinkedList<List<Character>> eachLine = new LinkedList<List<Character>>();
			String line = readLines.nextLine();
			//boolean inParens = false;
			int k = 0;
			while (k < line.length()){
				LinkedList<Character> characters = new LinkedList<Character>();
				if (line.charAt(k) == '('){
					k++;
					while (line.charAt(k) != ')'){
						characters.add(line.charAt(k));
						k++;
					}
				} else {
					//LinkedList<Character> characters = new LinkedList<Character>();
					characters.add( line.charAt(k));
				}
				k++;
				eachLine.add(characters);
			}
			tests.add(eachLine);
		}
		return tests;
	}
	
	public static void checkAndPrint(Set<String> dictionary, List<List<List<Character>>> tests, int l) {
		File writeTo = new File("output.out");
		try {
			PrintWriter out = new PrintWriter(new FileWriter(writeTo));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException e");
		}
		
		int caseCount = 0;
		
		for (List<List<Character>> line : tests) {
			caseCount++;
			int wordCount = 0;
			ArrayList<char[]> wordList = new ArrayList<char[]>();
			
				
		
		}
	}
}
