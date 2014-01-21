
import java.util.*;
public class ProblemFour {

	public static void main(String[] args) {
		System.out.println(calculate());
	}

	public static int calculate() {
		int highest = 0;
		for (int i = 1; i < 1000; i++) {
			for (int j = 1; j < 1000; j++) {
				if (isPalindrome(i * j) && i* j > highest) {
					highest = i * j;
				}
			}
		}
		return highest;
	}
	
	public static boolean isPalindrome(int a) {
		ArrayList<Integer> intList = new ArrayList<Integer>();
		while (a > 0) {
			intList.add(0, a % 10);
			a /= 10;
		}
		intList.trimToSize();
		while (intList.size() > 1) {
			if (intList.get(0) != intList.get(intList.size() - 1)) {
				return false;
			}
			intList.remove(0);
			intList.remove(intList.size() - 1);
			intList.trimToSize();
		}
		return true;
	}
}