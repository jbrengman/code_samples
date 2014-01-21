import java.util.*;
import java.io.*;
public class ProblemEleven {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		
		Scanner readLine = new Scanner(new File("/home/jordan/workspace/project euler/bin/numbers.txt"));
		ArrayList<List<Integer>> numArrayList = createArray(readLine);
		//System.out.println(numArrayList);
		int max = findMax(numArrayList);
		System.out.println(max);
	}

	public static ArrayList<List<Integer>> createArray(Scanner readLine) {
		ArrayList<List<Integer>> numArrayList = new ArrayList<List<Integer>>();
		while(readLine.hasNext()) {
			String line = readLine.nextLine();
			Scanner readNum = new Scanner(line);
			List<Integer> rowList = new ArrayList<Integer>();
			while(readNum.hasNextInt()) {
				rowList.add(readNum.nextInt());
			}
			numArrayList.add(rowList);
		}
		return numArrayList;
	}
	
	public static int findMax(ArrayList<List<Integer>> numArrayList) {
		int max = 0;
		for (int i = 0; i < numArrayList.size(); i++) {
			List<Integer> rowList = numArrayList.get(i);
			for (int j = 0; j < rowList.size(); j++) {
				int total = 0;
				
				//check horizontally to the right
				if (j < rowList.size() - 3) {
					total = rowList.get(j) * rowList.get(j + 1) * rowList.get(j + 2) * rowList.get(j + 3);
					if (total > max) {
						max = total;
					}
				}
				
				//check vertically
				if (i < numArrayList.size() - 3) {
					total = numArrayList.get(i).get(j) * numArrayList.get(i + 1).get(j) * 
							numArrayList.get(i + 2).get(j) * numArrayList.get(i + 3).get(j);
					if (total > max) {
						max = total;
					}
				}
				
				//check diagonally down to the right
				if ((i < numArrayList.size() - 3) && (j < rowList.size() - 3)) {
					total = numArrayList.get(i).get(j) * numArrayList.get(i + 1).get(j + 1) * 
							numArrayList.get(i + 2).get(j + 2) * numArrayList.get(i + 3).get(j + 3);
					if (total > max) {
						max = total;
					}
				}
				
				//check diagonally down to the left
				if ((i < numArrayList.size() - 3) && (j >= 3)) {
					total = numArrayList.get(i).get(j) * numArrayList.get(i + 1).get(j - 1) * 
							numArrayList.get(i + 2).get(j - 2) * numArrayList.get(i + 3).get(j - 3);
					if (total > max) {
						max = total;
					}
				}
			}
		}
		return max;
	}
	
}
