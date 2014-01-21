/* Jordan Brengman
	ENGR 143
	Lab 9 */
	

import java.util.*;	
public class IntQueue {

	public static void main(String[] args) {
		Queue<Integer> q = build();
		iterate(q);
		System.out.println();
		remove(q);
	}
	
	public static Queue<Integer> build() {
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			q.add(i);
		}
		return q;
	}
	
	public static void iterate(Queue<Integer> q) {
		Iterator<Integer> i = q.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}
	
	public static void remove(Queue<Integer> q) {
		while (!q.isEmpty()) {
			System.out.println(q.remove());
		}
	}
		
}