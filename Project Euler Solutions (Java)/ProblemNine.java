
import java.util.*;
public class ProblemNine {

	public static void main(String[] args) {
		System.out.println(calculate());
	}

	public static int calculate() {
		Random r = new Random();
		int a = -1;
		int b = -1;
		while (a * a + b * b != (1000 - (a + b)) * (1000 - (a + b))) {
			a = 1 + r.nextInt(1000);
			b = 1 + r.nextInt(1000);
		}
		return a * b * (1000 - a - b);
	}
}