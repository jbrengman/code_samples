import java.util.*;
import java.io.*;

public class FairAndSquare {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner s = new Scanner(new File("input.in"));
		PrintStream p = new PrintStream(new File("output.out"));

		int cases = s.nextInt();
		s.nextLine();

		for (int i = 0; i < cases; i++) {
			int lowerBound = s.nextInt();
			int upperBound = s.nextInt();
			if (s.hasNextLine()) {
				s.nextLine();
			}
			int result = fair(lowerBound, upperBound);
			p.println(String.format("Case #%s: ", i + 1) + result);
		}
	}

	public static int fair(int lowerBound, int upperBound) {
		int count = 0;
		for (int i = lowerBound; i <= upperBound; i++) {
			double sqrt = Math.sqrt(i);
			int sqrtInt;
			if ((sqrt % 1) == 0) {
				sqrtInt = (int) sqrt;
				if (palindrome(i) && palindrome(sqrtInt)) {
					count++;
				}
			}
		}
		return count;
	}

	public static boolean palindrome(int inInt) {
		String s = "" + inInt;
		String rev = "";
		for (int i = s.length(); i > 0; i--) {
			rev += s.substring(i - 1, i);
		}
		return (s.equals(rev));
	}
}