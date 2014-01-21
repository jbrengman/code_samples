/*	Jordan Brengman
	ENGR 143
	CircularlyLinkedIntList */
	
	
import java.util.*;	
public class CircularlyLinkedIntListClient {
	
	public static void main(String[] args) {
		
		CircularlyLinkedIntList one = new CircularlyLinkedIntList();
		
		// add(value)
		one.add(0);
		one.add(1);
		one.add(2);
		one.add(3);
		one.add(4);
		one.add(5);
		one.add(6);
		one.add(7);
		one.add(8);
		one.add(9);
		System.out.println(one + "\n expects \n[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]\n");
		
		// remove(index)
		one.remove(0);
		one.remove(4);
		one.remove(7);
		System.out.println(one + "\n expects \n[1, 2, 3, 4, 6, 7, 8]\n");
		
		// add(index, value)
		one.add(4, 5);
		System.out.println(one + "\n expects \n[1, 2, 3, 4, 5, 6, 7, 8]\n");
		
		// set(index, value)
		one.set(0, 10);
		one.set(7, 10);
		System.out.println(one + "\n expects \n[10, 2, 3, 4, 5, 6, 7, 10]\n");
		
		// get(index)
		System.out.println(one.get(2) + " expects 3\n");
		
		// indexOf(value)
		System.out.println(one.indexOf(10) + " expects 0\n");
		System.out.println(one.indexOf(11) + " expects -1\n");
		
		// lastIndexOf(value)
		System.out.println(one.lastIndexOf(10) + " expects 7\n");
		System.out.println(one.lastIndexOf(11) + " expects -1\n");
		
		// contains(value)
		System.out.println(one.contains(3) + " expects true\n");
		System.out.println(one.contains(8) + " expects false\n");
		
		// remove(value)
		one.removeValue(10);
		System.out.println(one + "\n expects \n[2, 3, 4, 5, 6, 7, 10]\n");
		one.removeValue(8);
		System.out.println(one + "\n expects \n[2, 3, 4, 5, 6, 7, 10]\n");
		
		CircularlyLinkedIntList two = new CircularlyLinkedIntList();
		CircularlyLinkedIntList three = new CircularlyLinkedIntList();
		two.add(3);
		two.add(4);
		two.add(5);
		three.add(3);
		three.add(4);
		three.add(5);
		
		// equals(LinkedIntList)
		System.out.println(two.equals(three) + " expects true\n");
		System.out.println(two.equals(one) + " expects false\n");
		
		// containsAll(LinkedIntList)
		System.out.println(one.containsAll(two) + " expects true\n");
		System.out.println(two.containsAll(one) + " expects false\n");
		
		// addAll(index, LinkedIntList)
		one.addAll(0, two);
		System.out.println(one + "\n expects \n[3, 4, 5, 2, 3, 4, 5, 6, 7, 10]\n");
		one.addAll(6, two);
		System.out.println(one + "\n expects \n[3, 4, 5, 2, 3, 4, 3, 4, 5, 5, 6, 7, 10]\n");
		
		// removeAll(LinkedIntList)
		one.removeAll(two);
		System.out.println(one + "\n expects \n[2, 6, 7, 10]\n");
		
		CircularlyLinkedIntList four = new CircularlyLinkedIntList();
		four.add(1);
		four.add(2);
		four.add(3);
		four.add(4);
		four.add(5);
		four.add(6);
		
		// retainAll(LinkedIntList)
		four.retainAll(one);
		System.out.println(four + "\n expects \n[2, 6]\n");
		
		// toArray
		int[] a1 = one.toArray();
		System.out.println(Arrays.toString(a1) + "\n expects\n[2, 6, 7, 10]\n");
	}	
	
}