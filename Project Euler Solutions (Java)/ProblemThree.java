public class ProblemThree {

	public static void main(String[] args) {
		System.out.println(calculate());
	}

	public static int calculate() {
		int largest = 0;
		int i = 0;
		//int a = 600851475143;
		while (i < a) {
			if (a % i == 0 && isPrime(a)) {
				largest = a;
			}
		i++;
		}
		return largest;
	}
	
	public static boolean isPrime(int a) {
		for (int i = 0; i < a; i++) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}
}