import java.util.*;
import java.io.*;

public class SwingingWild {

	public static void main(String[] args) throws FileNotFoundException {

	Scanner s = new Scanner(new File("input.in"));
	PrintStream p = new PrintStream(new File("output.out"));
	
	int cases = s.nextInt();
	s.nextLine();

	for (int i = 0; i < cases; i ++) {
		ArrayList<ArrayList<Integer>> vineData = new ArrayList<ArrayList<Integer>>();
		int vines = s.nextInt();
		s.nextLine();
		for (int j = 0; j < vines; j++) {
			vineData.add(new ArrayList<Integer>(Arrays.asList(s.nextInt(), s.nextInt())));
			s.nextLine();
		}
		int dist = s.nextInt();
		//s.nextLine();

		String result = find(vines, vineData, dist);

		p.println(String.format("Case #%s: ", i + 1) + result);
	}

	}

	public static String find(int vines, ArrayList<ArrayList<Integer>> vineData, int dist) {
		
		int pos = vineData.get(0).get(1);
		if (pos < vineData.get(0).get(0)) {
			return "NO";
		}

		for (int i = 0; i < vineData.size(); i++) {
			
		}

		
		for (int i = 0; i < vineData.size(); i++) {
			int l = vineData.get(i).get(1);
			int target = vineData.get(i + 1).get(0);
			if (pos + l < target) {
				return "NO";
			} else {
				pos = target;
			}
			if (pos >= dist) {
				return "YES";
			}
		}
		return "NO";
	}




		for (int i = 0; i < vineData.size() - 2; i++) {
			if ((pos + vineData.get(i).get(1)) < (vineData.get(i + 1).get(0))) {
				return "NO";
			} else {
				pos = vineData.get(i).get(1);
			}
		}
		if (pos + vineData.get(vineData.size() - 1).get(1) >= dist) {
			return "YES";
		}
		return "NO";
	}

}