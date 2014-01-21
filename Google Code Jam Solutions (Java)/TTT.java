import java.util.*;
import java.io.*;

public class TTT {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner s = new Scanner(new File("input.in"));
		PrintStream p = new PrintStream(new File("output.out"));

		int cases = s.nextInt();
		s.nextLine();

		for (int i = 0; i < cases; i++) {
			boolean hasEmpty = false;
			String[][] game = new String[4][4];
			for (int j = 0; j < 4; j++) {
				String line = s.nextLine();
				for (int k = 0; k < 4; k++) {
					game[j][k] = line.substring(k, k + 1);
					if (game[j][k].equals(".")) {
						hasEmpty = true;
					}
				}
			}
			if (s.hasNextLine()) {
				s.nextLine();
			}
			String result = "Game has not completed";

			if (chkDiagLtoR(game, "X") ||
						chkDiagRtoL(game, "X") ||
						chkRows(game, "X") ||
						chkColumns(game, "X")) {
				result = "X won";
			} else if (chkDiagLtoR(game, "O") ||
						chkDiagRtoL(game, "O") ||
						chkRows(game, "O") ||
						chkColumns(game, "O")) {
				result = "O won";
			} else if (hasEmpty == false) {
				result = "Draw";
			}
			p.println(String.format("Case #%s: ", i + 1) + result);
		}
	}

	public static boolean chkDiagLtoR(String[][] game, String c) {
		return ((game[0][0].equals(c) || game[0][0].equals("T")) &&
				(game[1][1].equals(c) || game[1][1].equals("T")) &&
				(game[2][2].equals(c) || game[2][2].equals("T")) &&
				(game[3][3].equals(c) || game[3][3].equals("T")) );
	}

	public static boolean chkDiagRtoL(String[][] game, String c) {
		return ((game[3][0].equals(c) || game[3][0].equals("T")) &&
				(game[2][1].equals(c) || game[2][1].equals("T")) &&
				(game[1][2].equals(c) || game[1][2].equals("T")) &&
				(game[3][0].equals(c) || game[3][0].equals("T")) );	
	}

	public static boolean chkRows(String[][] game, String c) {
		for (int i = 0; i < 4; i++) {
			if ((game[i][0].equals(c) || game[i][0].equals("T")) &&
				(game[i][1].equals(c) || game[i][1].equals("T")) &&
				(game[i][2].equals(c) || game[i][2].equals("T")) &&
				(game[i][3].equals(c) || game[i][3].equals("T")) ) {
				return true;
			}
		}
		return false;
	}

	public static boolean chkColumns(String[][] game, String c) {
		for (int i = 0; i < 4; i++) {
			if ((game[0][i].equals(c) || game[0][i].equals("T")) &&
				(game[1][i].equals(c) || game[1][i].equals("T")) &&
				(game[2][i].equals(c) || game[2][i].equals("T")) &&
				(game[3][i].equals(c) || game[3][i].equals("T")) ) {
				return true;
			}
		}
		return false;
	}

}