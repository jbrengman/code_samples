
import java.util.*;
public class ProblemEleven {

	public static void main(String[] args) {
		System.out.println(calculate());
	}

	public static int calculate() {
		int thePrime = 0;
		int total = 0;
		while (thePrime <= 2000000) {		
			if (isPrime(thePrime)) {
				total += thePrime;
			}
			thePrime++;
		}
		return total;
	}
	
	public static boolean isPrime(int a) {
		for (int i = 2; i < a; i++) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}
}