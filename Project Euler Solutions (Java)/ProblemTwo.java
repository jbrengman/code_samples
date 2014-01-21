public class ProblemTwo {

	public static void main(String[] args) {
		System.out.println(calculate());
	}

	public static int calculate() {
		int total = 0;
		int current = 1;
		int last = 0;
		int temp = 0;
		while (current < 4000000) {
			if (current % 2 == 0) {
				total += current;
			}
			temp = current;
			current += last;
			last = temp;
		}
		return total;
	}
}