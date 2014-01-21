import java.util.*;
import java.io.*;

public class DancingWithTheGooglers {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("input.in"));
		PrintStream pStream = new PrintStream(new File("output.out"));
		int cases = Integer.parseInt(s.nextLine());
		for (int i = 0; i < cases; i++) {
			String nextL = s.nextLine();
			String outString = String.format("Case #%s: ", i + 1);
			outString += result(nextL);
			pStream.println(outString);
		}
	}

	public static int result(String line) {
		Scanner s = new Scanner(line);
		int googlers = s.nextInt();
		int surprises = s.nextInt();
		int bestResult = s.nextInt();
		ArrayList<Integer> scores = new ArrayList<Integer>();
		while (s.hasNextInt()) {
			scores.add(s.nextInt());
		}
		int returnVal = 0;
		for (int score : scores) {
			if ((score + 2) / 3 >= bestResult) {
				returnVal++;
			} else if (surprises > 0 && score >= 2 && (score + 4) / 3 >= bestResult) {
				returnVal++;
				surprises--;
			}
		}
		return returnVal;
	}

}