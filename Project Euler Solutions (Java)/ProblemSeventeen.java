
public class ProblemSeventeen {
	


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] single = {0, 3, 3, 5, 4, 4, 3, 5, 5, 4};
		int[] teen = {3, 6, 6, 8, 8, 7, 7, 9, 8, 8};
		int[] tens = {6, 6, 5, 5, 5, 7, 6, 6};
		int[] hundreds = {0, 13, 13, 15, 14, 14, 13, 15, 15, 14};
		int thousand = 11;		
		
		int total = 0;
		total += thousand;
		
		for (int i : hundreds) {
			for (int j : single){
				total = total + i + j;
				if (i != 0 && j == 0){ // take out the "and" if the number is one hundred, two hundred, etc.
					total -= 3;
				}
				//System.out.println(i + " " + j + " total: " + total);
			}
			for (int j : teen){
				total = total + i + j;
				//System.out.println(i + " " + j + " total: " + total);
			}
			for (int j : tens){
				for (int k : single){
					total = total + i + j + k;
					//System.out.println(i + " " + j + " " + k + " total: " + total);
				}
			}
		}
		System.out.println(total);
	}

}
