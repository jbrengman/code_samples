public class ProblemOne {

public static void main(String[] args) {
	System.out.println(calculate());
}

public static int calculate() {
	int total = 0;
	for (int i = 0; i < 1000; i++) {
		if (i % 3 == 0 || i % 5 == 0) {
			total += i;
		}
	}
	return total;
}

}