import java.util.*;
import java.io.*;
public class SpeakingInTongues {
	public static void main(String[] args) throws FileNotFoundException {
		String inOne = "ejp mysljylc kd kxveddknmc re jsicpdrysi";
		String inTwo = "rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd";
		String inThree = "de kr kd eoya kw aej tysr re ujdr lkgc jv";
		String inFour = "yeq";
		String outOne = "our language is impossible to understand";
		String outTwo = "there are twenty six factorial possibilities";
		String outThree = "so it is okay if you want to just give up";
		String outFour = "aoz";
		ArrayList<String> inL = new ArrayList<String>();
		inL.add(inOne);
		inL.add(inTwo);
		inL.add(inThree);
		inL.add(inFour);
		ArrayList<String> outL = new ArrayList<String>();
		outL.add(outOne);
		outL.add(outTwo);
		outL.add(outThree);
		outL.add(outFour);

		HashMap<String, String> key = createKey(inL, outL);

		Scanner readLines = new Scanner(new File("input.in"));
		int numLines = Integer.parseInt(readLines.nextLine());

		ArrayList<String> decryptThese = new ArrayList<String>();
		for (int i = 0; i < numLines; i++) {
			decryptThese.add(readLines.nextLine());
		}
		readLines.close();

		String toPrint = translate(decryptThese, key);

		PrintStream pStream = new PrintStream(new File("output.out"));
		pStream.print(toPrint);
		pStream.close();

	}

	public static HashMap<String, String> createKey(
				ArrayList<String> inL, ArrayList<String> outL) {

		HashMap<String, String> key = new HashMap<String, String>();

		if (inL.size() != outL.size()) {
			throw new IllegalArgumentException("come on now...");
		}

		for (int i = 0; i < inL.size(); i++) {
			String in = inL.get(i);
			String out = outL.get(i);
			for (int j = 0; j < in.length(); j++) {
				key.put(in.substring(j, j + 1), out.substring(j, j + 1));
			}
		}
		key.put("z", "q");
		return key;
	}

	public static String translate(ArrayList<String> text, HashMap<String, String> key) {
		String toPrint = "";
		for (int i = 0; i < text.size(); i++) {
			String in = text.get(i);
			String out = String.format("Case #%s: ", i + 1);
			for (int j = 0; j < in.length(); j++) {
				out += key.get(in.substring(j, j + 1));
			}
			toPrint = toPrint + out + "\n";
		}
		return toPrint;
	}
}