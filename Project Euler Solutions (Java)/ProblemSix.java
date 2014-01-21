
import java.util.*;
public class ProblemSix {

	public static void main(String[] args) {
		System.out.println(calculate());
	}

	public static int calculate() {
		int thePrime = 3;
		int count = 2;
		while (count <= 10001) {		
			if (isPrime(thePrime)) {
				if (count == 10001) {
					return thePrime;
				}
				count++;
			}
			thePrime++;
		}
		return 0;
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