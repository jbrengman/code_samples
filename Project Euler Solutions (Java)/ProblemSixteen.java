import java.util.*;
public class ProblemSixteen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> num = new ArrayList<Integer>();
		num.add(1);
		for (int i = 0; i < 1000; i++) {
			for (int j = num.size() - 1; j >= 0; j--) {
				num.set(j, num.get(j) * 2);
			}
			for (int j = num.size() - 1; j >= 0; j--) {
				if (num.get(j) > 9) {
					if (j == 0) {
						num.add(0, 1);
						num.set(1, num.get(1) - 10);
						j++;
					} else {
						num.set(j - 1, num.get(j - 1) + 1);
						num.set(j, num.get(j) - 10);
						j++;
					}
				}
			}
		}
		long total = 0;
		for (Integer i : num) {
			total += i;
		}
		System.out.println(total);
	}
}
