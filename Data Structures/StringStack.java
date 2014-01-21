/* Jordan Brengman
	ENGR 143
	Lab 9 */
	

import java.util.*;	
public class StringStack {

	public static void main(String[] args) {
		Stack<String> s = build();
		iterate(s);
		System.out.println();
		remove(s);
	}
	
	public static Stack<String> build() {
		Stack<String> s = new Stack<String>();
		for (int i = 0; i < 10; i++) {
			s.push(i + "");
		}
		return s;
	}
	
	public static void iterate(Stack<String> s) {
		Iterator<String> i = s.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}
	
	public static void remove(Stack<String> s) {
		while (!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}
		
}