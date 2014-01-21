
import java.util.*;
public class ProblemFive {

	public static void main(String[] args) {
		System.out.println(calculate());
	}

	public static int calculate() {
		int highest = 0;
		int i = 1;
		while (highest == 0) {
			if (isDivisible(i)) {
				return i;
			}
			i++;
		}
		return 0;
	}
	
	public static boolean isDivisible(int a) {
		for (int i = 1; i <= 20; i++) {
			if (a % i != 0) {
				return false;
			}
		}
		return true;
	}
}