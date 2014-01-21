/* Jordan Brengman
	ENGR 143
	Lab 9 */
	

import java.util.*;	
public class StringQueue {

	public static void main(String[] args) {
		Queue<String> q = build();
		iterate(q);
		System.out.println();
		remove(q);
	}
	
	public static Queue<String> build() {
		Queue<String> q = new LinkedList<String>();
		for (int i = 0; i < 10; i++) {
			q.add(i + "");
		}
		return q;
	}
	
	public static void iterate(Queue<String> q) {
		Iterator<String> i = q.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}
	
	public static void remove(Queue<String> q) {
		while (!q.isEmpty()) {
			System.out.println(q.remove());
		}
	}
		
}