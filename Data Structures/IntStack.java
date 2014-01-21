/* Jordan Brengman
	ENGR 143
	Lab 9 */
	

import java.util.*;	
public class IntStack {

	public static void main(String[] args) {
		Stack<Integer> s = build();
		iterate(s);
		System.out.println();
		remove(s);
	}
	
	public static Stack<Integer> build() {
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < 10; i++) {
			s.push(i);
		}
		return s;
	}
	
	public static void iterate(Stack<Integer> s) {
		Iterator<Integer> i = s.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}
	
	public static void remove(Stack<Integer> s) {
		while (!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}
		
}