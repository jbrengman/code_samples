/*	Jordan Brengman
	ENGR 143
	HW 9 */
	

import java.util.*;	
public class SearchTreeClient {

	public static void main(String[] args) {
		
		// add
		System.out.println("add");
		SearchTree<String> one = new SearchTree<String>();
		one.add("1");
		one.add("12");
		one.add("32");
		one.add("44");
		one.print();
		System.out.println("expects 1 12 32 44");
		
		line();
		
		// addAll
		System.out.println("addAll");
		SearchTree<String> two = new SearchTree<String>();
		two.add("11");
		two.add("8");
		two.add("15");
		two.add("4");

		one.addAll(two);
		one.print();
		System.out.println("expects 1 11 12 15 32 4 44 8");
		
		line();
		
		// clear 
		System.out.println("clear");
		two.clear();
		System.out.println("expects (nothing)");
		
		line();
		
		//containsAll
		System.out.println("containsAll");
		two.add("11");
		two.add("32");
		two.add("44");
		two.add("8");
		System.out.println(one.containsAll(two) + " expects true\n" + two.containsAll(one) + " expects false");
		
		line();
		
		// equals
		System.out.println("equals");
		SearchTree<String> three = new SearchTree<String>();
		three.add("11");
		three.add("32");
		three.add("44");
		three.add("8");
		System.out.println(three.equals(two) + " expects true\n" + three.equals(one) + " expects false");
		
		line();
		
		// isEmpty
		System.out.println("isEmpty");
		three.clear();
		System.out.println(three.isEmpty() + " expects true\n" + one.isEmpty() + " expects false");
		
		line();
		
		// remove
		System.out.println("remove");
		one.remove("1");
		one.remove("8");
		one.remove("12");
		one.print();
		System.out.println("expects 11 15 32 4 44");
		
		line();
		
		// removeAll
		System.out.println("removeAll");
		one.removeAll(two);
		one.print();
		System.out.println("expects 15 4");
		
		line();
		
		// retainAll
		System.out.println("retainAll");
		one.add("8");
		one.add("44");
		one.add("100");
		one.add("11");
		one.add("32");
		one.retainAll(two);
		one.print();
		System.out.println("expects 11 32 44 8");
		
		line();
		
		// toArray
		System.out.println("toArray");
		System.out.println(Arrays.toString(one.toArray()) + "\nexpects\n[8, 44, 32, 11]");
		
		line();
		
	// Iterator
		System.out.println("Iterator methods hasNext and next\n");

		SearchTree<String> four = new SearchTree<String>();
		four.add("12");
		four.add("1");
		four.add("32");
		four.add("44");
		four.add("20");

		Iterator i = four.iterator();
	
		System.out.println(i.hasNext() + " expects true");
		System.out.println(i.next() + " expects 12");
		System.out.println(i.hasNext() + " expects true");
		System.out.println(i.next() + " expects 1");
		System.out.println(i.hasNext() + " expects true");
		System.out.println(i.next() + " expects 32");
		System.out.println(i.hasNext() + " expects true");
		System.out.println(i.next() + " expects 20");
		System.out.println(i.hasNext() + " expects true");
		System.out.println(i.next() + " expects 44");
		System.out.println(i.hasNext() + " expects false\n");
		
		System.out.println("Iterator remove method\n");
		
		i.remove();
		four.print();
		System.out.println("expects 1 12 20 32");
		
		
	}
	
	public static void line() {
		System.out.println("\n********************\n");
	}
}