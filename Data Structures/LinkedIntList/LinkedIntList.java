/* Jordan Brengman
	ENGR 143
	LinkedIntList */
	
	
/**
* @author Jordan Brengman
*/

import java.util.*;	
public class LinkedIntList implements IntList {

// Fields

	private ListNode front;

// Constructor

	/**
	*
	*/
	public LinkedIntList() {
		front = null;
	}

// Methods

	// Methods from chapter 16

	/**
	* @return Returns the number of elements in the LinkedIntList.
	*/
	public int size() {
		int count = 0;
		ListNode current = front;
		while (current != null) {
			current = current.next;
			count++;
		}
		return count;
	}
	
	/**
	* @param index The index at which to retrieve the value.
	* @return Returns the integer at the specified index.
	*/
	public int get(int index) {
		checkIndex(index);
		return nodeAt(index).data;
	}
	
	/**
	* @return Returns a string representation of the list.
	*/
	public String toString() {
		if (front == null) {
			return "[]";
		} else {
			String result = "[" + front.data;
			ListNode current = front.next;
			while (current != null) {
				result += ", " + current.data;
				current = current.next;
			}
			result += "]";
			return result;
		}
	}
	
	/**
	* @param value The value whose index is to be found.
	* @return Returns the first index at which the given value is found.
	*/
	public int indexOf(int value) {
		int index = 0;
		ListNode current = front;
		while (current !=  null) {
			if (current.data == value) {
				return index;
			}
			index++;
			current = current.next;
		}
		return -1;
	}
	
	/**
	*	@param value The value to be added to the end of the list.
	*/
	public void add(int value) {
		if (front == null) {
			front = new ListNode(value);
		} else {
			ListNode current = front;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new ListNode(value);
		}
	}
	
	/**
	* @param index The index at which value is to be added to the list.
	* @param value The value to be added to the list.
	*/
	public void add(int index, int value) {
		checkIndex(index);
		if (index == 0) {
			front = new ListNode(value, front);
		} else {
			ListNode current = nodeAt(index - 1);
			current.next = new ListNode(value, current.next);
		}
	}
	
	/**
	*	@param index The index to be removed from the list.
	*/
	public void remove(int index) {
		checkIndex(index);
		if (index == 0) {
			front = front.next;
		} else {
			ListNode current = nodeAt(index - 1);
			current.next = current.next.next;
		}
	}
	
	/**
	* @param index The index whose node is to be returned.
	* @return ListNode Returns the ListNode found at index.
	*/
	private ListNode nodeAt(int index) {
		checkIndex(index);
		ListNode current = front;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}


	// New methods
	
	/**
	* @param value The value to search for within the list.
	*/
	public boolean contains(int value) {
		return indexOf(value) >= 0;
	}
	
	/**
	* @param index The index at which list is to be added to this LinkedIntList.
	* @param list The linkedIntList to be added to this LinkedIntList at index.
	*/
	public void addAll(int index, LinkedIntList list) {
			checkIndex(index);
			ListNode current = list.front;
			for (int i = index; i < list.size() + index; i++) {
				add(i, current.data);
				current = current.next;
			}
	}
	
	/**
	* @param list The list to compare with this LinkedIntList.
	* @return Returns true if this list contains all values found in list.
	*/
	public boolean containsAll(LinkedIntList list) {
		ListNode current = list.front;
		while (current != null) {
			if (!contains(current.data)) {
				return false;
			}
			current = current.next;
		}
		return true;
	}
	
	/**
	* @param o The object to compare with this list.
	* @return Returns true if o is a LinkedIntList of same size and containing the same elements as
	* this LinkedIntList.
	*/
	public boolean equals(Object o) {
		if (o instanceof LinkedIntList && size() == ((LinkedIntList) o).size()) {
			ListNode thisCurrent = front;
			ListNode otherCurrent = ((LinkedIntList) o).front;
			while (thisCurrent != null) {
				if (thisCurrent.data != otherCurrent.data) {
					return false;
				}
				thisCurrent = thisCurrent.next;
				otherCurrent = otherCurrent.next;
			}
			return true;
		}
		return false;
	}
	
	/**
	* @param value The value whose last occurence in this list is to be found.
	* @return Returns the last index at which value is found, returns -1 if value is not found
	* in this list.
	*/
	public int lastIndexOf(int value) {
		int index = -1;
		int count = 0;
		ListNode current = front;
		while (current != null) {
			if (current.data == value) {
				index = count;
			}
			current = current.next;
			count++;
		}
		return index;
	}
	
	/**
	* @param value The value to be removed from this list at its first found occurence.
	* @return Returns true if the value is found and removed, returns false otherwise.
	*/
	// Replaces public boolean remove(Object o)
	public boolean removeValue(int value) {
		ListNode current = front;
		int indexCount = 0;
		while (current != null) {
			if (current.data == value) {
				remove(indexCount);
				return true;
			}
			current = current.next;
			indexCount++;
		}
		return false;
	}
	
	/**
	* @param list The list of values to be removed from this LinkedIntList.
	*/
	public void removeAll(LinkedIntList list) {
		ListNode current = list.front;
		while (current != null) {
			while (contains(current.data)) {
				removeValue(current.data);
			}
			current = current.next;
		}
	}
	
	/**
	* @param list The list of values to be retained within this LinkedIntList.
	*/
	public void retainAll(LinkedIntList list) {
		ListNode current = front;
		int index = 0;
		while (current != null) {	
			if (!list.contains(current.data)) {
				remove(index);
			
			} else {
				index++;
			}
			current = current.next;
		}
	}
	
	/**
	* @return Returns an integer array containing all the values found in this LinkedIntList.
	*/
	public int[] toArray() {
		int[] a = new int[size()];
		int indexCount = 0;
		ListNode current = front;
		while (current != null) {
			a[indexCount] = current.data;
			current = current.next;
			indexCount++;
		}
		return a;
	}
	
	/**
	* @param index The index whose value is to be changed to value.
	* @param value The new value to be set at index.
	*/
	public void set(int index, int value) {
		nodeAt(index).data = value;
	}
	
	/**
	* @param index The index to check.
	* @throws IndexOutOfBoundException if index is not within the range of this list.
	*/
	private void checkIndex(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("index: " + index);
		}
	}
	
	/**
	* @return Returns true if size = 0, returns false otherwise.
	*/
	public boolean isEmpty() {
		return size() == 0;
	}
	
}