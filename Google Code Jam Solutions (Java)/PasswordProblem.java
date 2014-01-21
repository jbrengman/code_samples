import java.util.*;
import java.io.*;

// Not finished, need to add solutions for deleting some number of characters
// other than all/none.

public class PasswordProblem {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("input.in"));
		PrintStream p = new PrintStream(new File("output.out"));

		int cases = s.nextInt();
		s.nextLine();

		for (int i = 0; i < cases; i++){
			int typed = s.nextInt();
			int len = s.nextInt();
			s.nextLine();
			String probLine = s.nextLine();
			Scanner s2 = new Scanner(probLine);
			ArrayList<Double> probs = new ArrayList<Double>();
			while (s2.hasNext()) {
				probs.add(Double.parseDouble(s2.next()));
			}
			double result = Math.min(
				Math.min(
					finish(typed, len, probs),
					delete(typed, len, probs)),
					restart(typed, len, probs));
			p.println(String.format("Case #%s: ", i + 1) + result);
		}
	}

	public static double finish(int typed, int len, ArrayList<Double> probs) {
		double probC = 1.0;
		for (double p : probs) {
			probC *= p;
		}
		double probI = 1.0 - probC;
		System.out.println(probC + " " + probI);
		double retVal = probC * (len - typed + 1.0) + probI * (len - typed + len + 2.0);
		System.out.println(retVal);
		return retVal;
	}

	public static double delete(int typed, int len, ArrayList<Double> probs) {
		double retVal = typed + len + 1;
		//System.out.println(retVal + "d");
		return retVal;
	}

	public static double restart(int typed, int len, ArrayList<Double> probs) {
		double retVal = len + 2;
		//System.out.println(retVal + "r");
		return retVal;
	}

}