import java.util.*;
public class ProblemFourteen {
	
	public static void main(String[] args) {
		int n = 1000000;
		long current;
		int start = n;
		int count;
		int maxCount = 0;
		while (n != 1) {
			current = n;
			count = 0;
			while (current > 1) {
				if (current % 2 == 0) {
					current = even(current);
				} else {
					current = odd(current);
				}
				count++;
			}
			if (count > maxCount) {
				maxCount = count;
				start = n;
			}
			n--;
		}
		System.out.println(start);
	}
	
	public static long even(long n) {
		return n / 2;
	}
	
	public static long odd(long n) {
		return (3 * n) + 1;
	}

}
