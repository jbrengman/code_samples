import java.util.*;
import java.io.*;
import java.math.*;

public class MinimumScalarProduct {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner input = new Scanner(new File("MinimumScalarProduct.in"));
		
		run(input);
	}
	
	public static void run(Scanner input) throws FileNotFoundException {
		
		PrintStream pStream = new PrintStream(new File("MiminumScalarProduct.out"));
		
		int caseNo = 0;
		
		input.nextLine();
		
		while (input.hasNextLine()) {
			
			caseNo++;
			input.nextLine();
			
			ArrayList<BigInteger> xCords = new ArrayList<BigInteger>();
			ArrayList<BigInteger> yCords = new ArrayList<BigInteger>();
			
			Scanner readLineX = new Scanner(input.nextLine());			
			while(readLineX.hasNext()) {
				xCords.add(new BigInteger(readLineX.next()));
			}
			
			Scanner readLineY = new Scanner(input.nextLine());			
			while(readLineY.hasNext()) {
				yCords.add(new BigInteger(readLineY.next()));
			}
			
			String min = getMinScalar(xCords, yCords);
			
			pStream.println("Case #" + caseNo + ": " + min);
		}
	}
	
	public static String getMinScalar(ArrayList<BigInteger> xCords, ArrayList<BigInteger> yCords) {
		
		Collections.sort(xCords);
		Collections.sort(yCords);
		Collections.reverse(yCords);
		
		BigInteger total = new BigInteger("0");
		
		for (int i = 0; i < xCords.size(); i++) {
			total = total.add(xCords.get(i).multiply(yCords.get(i))); // total = total + (xCords.get(i) * yCords.get(i));
		}
		
		return total.toString();
	}
	
}
