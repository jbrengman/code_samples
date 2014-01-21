import java.util.*;
import java.io.*;

public class StoreCredit {

	public static void main(String[] args) throws FileNotFoundException{
		long time = System.currentTimeMillis();
		
		Scanner input = new Scanner(new File("StoreCredit.in"));
		
		run(input);
		
		System.out.println(System.currentTimeMillis() - time + " milliseconds");
		
	}
	
	public static void run(Scanner input) throws FileNotFoundException {
		
		PrintStream pStream = new PrintStream(new File("StoreCredit.out"));
		
		input.nextInt();
		
		int caseNo = 0;
		
		while (input.hasNext()) {
			
			caseNo++;
			
			String output = "Case #" + caseNo + ":";
			
			int credit = input.nextInt();
			
			input.nextLine(); // skip to next line
			input.nextLine(); // skip to next line (this line is useless)
			
			String line = input.nextLine();
			
			Scanner readLine = new Scanner(line);
			
			ArrayList<Integer> aList = new ArrayList<Integer>();
			
			while(readLine.hasNextInt()) {
				aList.add(readLine.nextInt());
			}
			int a = -1;
			int b = -1;
			
			loop:
			for (int i = 0; i < aList.size() - 1; i++) {
				for (int j = i + 1; j < aList.size(); j++) {
					if(aList.get(i) + aList.get(j) == credit) {
						a = i + 1;
						b = j + 1;
						pStream.println(output + " " + a + " " + b);
						break loop;
					}
				}
			}
		}
		
	}
	
}
