import java.util.*;
public class ProblemTwelve {
	
	public static void main(String[] args){
		int tri = 0;
		int incr = 1;
		int divisors = 0;
		while (divisors < 500) {
			tri += incr;
			incr++;
			divisors = checkDiv(tri);
		}
		System.out.println(tri);
	}
	
	public static int checkDiv(int tri) {
		Set<Integer> divs = new HashSet<Integer>();
		for (int i = 1; i <= Math.sqrt(tri); i++) {
			if (tri % i == 0) {
				divs.add(i);
			}
		}
		LinkedList<Integer> divList = new LinkedList<Integer>(divs);
		for(int div : divList) {
			divs.add(tri / div);
		}
		return divs.size();
	}
}
