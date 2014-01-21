/* Jordan Brengman
	ENGR 143
	HW 7 ArrayIntList */
	

import java.util.*;	
public class ArrayIntListClient {

	public static void main(String[] args) {
	
		ArrayIntList one = new ArrayIntList();
		
		// isEmpty
		System.out.println(one.isEmpty() + " expects true\n");
		
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
		
		// isEmpty
		System.out.println(one.isEmpty() + " expects false\n");
		
		// remove(index)
		one.remove(0);
		one.remove(4);
		one.remove(7);
		System.out.println(one + "\n expects \n[1, 2, 3, 4, 6, 7, 8]\n");
		
		// add(index, value)
		one.add(4, 5);
		System.out.println(one + "\n expects \n[1, 2, 3, 4, 5, 6, 7, 8]\n");
		
		// set(inxex, value)
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
		
		// removeValue(value)
		System.out.println(one.removeValue(10) + " expects true");
		System.out.println(one + "\n expects \n[2, 3, 4, 5, 6, 7, 10]\n");
		System.out.println(one.removeValue(8) + " expects false");
		System.out.println(one + "\n expects \n[2, 3, 4, 5, 6, 7, 10]\n");
		
		ArrayIntList two = new ArrayIntList();
		ArrayIntList three = new ArrayIntList();
		two.add(3);
		two.add(4);
		two.add(5);
		three.add(3);
		three.add(4);
		three.add(5);
		
		// equals(ArrayIntList)
		System.out.println(two.equals(three) + " expects true\n");
		System.out.println(two.equals(one) + " expects false\n");
		
		// containsAll(ArrayIntList)
		System.out.println(one.containsAll(two) + " expects true\n");
		System.out.println(two.containsAll(one) + " expects false\n");
		
		// addAll(index, ArrayIntList)
		one.addAll(0, two);
		System.out.println(one + "\n expects \n[3, 4, 5, 2, 3, 4, 5, 6, 7, 10]\n");
		one.addAll(6, two);
		System.out.println(one + "\n expects \n[3, 4, 5, 2, 3, 4, 3, 4, 5, 5, 6, 7, 10]\n");
		
		// removeAll(ArrayIntList)
		one.removeAll(two);
		System.out.println(one + "\n expects \n[2, 6, 7, 10]\n");
		
		ArrayIntList four = new ArrayIntList();
		four.add(1);
		four.add(2);
		four.add(3);
		four.add(4);
		four.add(5);
		four.add(6);
		
		// retainAll(ArrayIntList)
		four.retainAll(one);
		System.out.println(four + "\n expects \n[2, 6]\n");
		
		// toArray
		int[] a1 = one.toArray();
		System.out.println(Arrays.toString(a1) + "\n expects\n[2, 6, 7, 10]\n");
		
		
		// Iterator tests
		ArrayIntList itArray = new ArrayIntList();
		itArray.add(0);
		itArray.add(1);
		itArray.add(2);
		itArray.add(3);
		itArray.add(4);
		itArray.add(5);
		
		ArrayIntListIterator i = itArray.iterator();
		
		// hasPrevious
		System.out.println(i.hasPrevious() + " expects false\n");
		// hasNext
		System.out.println(i.hasNext() + " expects true\n");
		// next
		System.out.println(i.next() + " expects 0\n");
		// next
		System.out.println(i.next() + " expects 1\n");
		// hasPrevious
		System.out.println(i.hasPrevious() + " expects true\n");
		// hasNext
		System.out.println(i.hasNext() + " expects true\n");
		// previousIndex
		System.out.println(i.previousIndex() + " expects 1\n");
		// nextIndex
		System.out.println(i.nextIndex() + " expects 2\n");
		// next
		System.out.println(i.next() + " expects 2\n");
		System.out.println(i.next() + " expects 3\n");
		// previous
		System.out.println(i.previous() + " expects 3\n");
		// add
		i.add(10);
		System.out.println(i.previous() + " expects 10\n");
		// set
		i.set(20);
		System.out.println(i.next() + " expects 20\n");
		// check rest of list and back
		System.out.println(i.next() + " " + i.next() + " " + i.next() + " expects 3 4 5\n");
		System.out.println(i.previous() + " " + i.previous() + " " + i.previous() + " " + 
				i.previous() + " " + i.previous() + " " + i.previous() + " expects 5 4 3 20 2 1");

	}	
}