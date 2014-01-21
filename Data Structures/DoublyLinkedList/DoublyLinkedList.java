/* Jordan Brengman
	ENGR 143
	DoublyLinkedList */
	
	
/**
* @author Jordan Brengman
*/

import java.util.*;
public class DoublyLinkedList<E> implements List<E> {

// Fields

	private ListNode<E> front;
	private ListNode<E> back;
	private int size;
	
	
// Constructor
	
	/**
	*
	*/
	public DoublyLinkedList() {
		front = new ListNode<E>(null);
		back = new ListNode<E>(null);
		clear();
	}


// Methods

	// Methods from chapter 16
	
	/**
	*	@return Returns the number of elements in this list.
	*/
	public int size() {
		return size;
	}
	
	/**
	* @param index The index whose element is to be returned.
	* @return Returns the element found at index.
	*/
	public E get(int index) {
		checkIndex(index);
		ListNode<E> current = nodeAt(index);
		return current.data;
	}
	
	/**
	* @return Returns a string representation of this list.
	*/
	public String toString() {
		if (size == 0) {
			return "[]";
		} else {
			String result = "[" + front.next.data;
			ListNode<E> current = front.next.next;
			while (current != back) {
				result += ", " + current.data;
				current = current.next;
			}
			result += "]";
			return result;
		}
	}
	
	/**
	* @param o The object whose first occurence in the list is to be found.
	* @return Returns the first index at which Object o is found, returns -1 if not found.
	*/
	public int indexOf(Object o) {
		int index = 0;
		ListNode<E> current = front.next;
		while (current !=  back) {
			if (current.data.equals(o)) {
				return index;
			}
			index++;
			current = current.next;
		}
		return -1;
	}
	
	
	/**
	* @return Returns true if this list contains 0 elements, returns false otherwise.
	*/
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	* @param value The element to be added to the end of the list.
	* @return Returns true.
	*/
	public boolean add(E value) {
		add(size, value);
		return true;
	}
	
	/**
	* @param index The index at which value is to be added to the list.
	* @param value The element to be added to the list at index.
	*/
	public void add(int index, E value) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("index: " + index);
		}
		ListNode<E> current = nodeAt(index - 1);
		ListNode<E> newNode = new ListNode<E>(value, current.next, current);
		current.next = newNode;
		newNode.next.prev = newNode;
		size++;
	}
	
	/**
	* @param other The list to be added to the end of this list.
	* @return Returns true if this list is changed.
	*/
	public boolean addAll(Collection<? extends E> other) {
		boolean changed = false;
		for (E value: other) {
			changed = true;
			add(value);
		}
		return changed;
	}
	
	/**
	* @param index The index whose element is to be removed from the list.
	* @return Returns the element that was previously found at index.
	*/
	public E remove(int index) {
		checkIndex(index);
		ListNode<E> dataNode = nodeAt(index - 1);
		ListNode<E> current = nodeAt(index - 1);
		current.next = current.next.next;
		current.next.prev = current;
		size--;
		return dataNode.data;
	}
	
	/**
	* @param index The index whose value is to be set.
	* @param value The value that index is to be set to.
	* @return Returns the element previously found at index.
	*/
	public E set(int index, E value) {
		checkIndex(index);
		ListNode<E> dataNode = nodeAt(index);
		ListNode<E> current = nodeAt(index);
		current.data = value;
		return dataNode.data;
	}
	
	/**
	*
	*/
	public void clear() {
		front.next = back;
		back.prev = front;
		size = 0;
	}
	
	/**
	* @return Returns a new LinkedListIterator.
	*/
	public ListIterator<E> listIterator(){
		return new LinkedListIterator();
	}
	
	/**
	* @param index The index at which the new LinkedListIterator will start at.
	* @return Returns a new LinkedListIterator starting at index.
	*/
	public ListIterator<E> listIterator(int index) {
		checkIndex(index);
		LinkedListIterator it = new LinkedListIterator();
		for (int i = 0; i < index; i++) {
			it.next();
		}
		return it;
	}
	
	/**
	* @return Returns a new LinkedIterator.
	*/
	public Iterator<E> iterator() {
		return new LinkedIterator();
	}
	
	/**
	* @param index Index whose ListNode is to be returned.
	8 @return Returns the ListNode found at index.
	*/
	private ListNode<E> nodeAt(int index) {
		ListNode<E> current;
		if (index < size / 2) {
			current = front;
			for (int i = 0; i < index + 1; i++) {
				current = current.next;
			}
		} else {
			current = back;
			for (int i = size; i >= index + 1; i--) {
				current = current.prev;
			}
		}
		return current;
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

	//New methods

	/**
	* @param index The index at which Collection c is to be inserted.
	* @param c The collection to be inserted at index.
	* @return Returns true if this list is changed.
	*/
	public boolean addAll(int index, Collection<? extends E> c) {
		checkIndex(index);
		boolean changed = false;
		int i = 0;
		for (E value : c) {
			changed = true;
			add(index + i, value);
			i++;
		}
		return changed;
	}
	
	/**
	* @param o The object to search for within the list.
	* @return Returns true if Object o is found within this list.
	*/
	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}
	
	/**
	* @param c The Collection whose values are to be searched for within this list.
	* @return Returns true if all elements in Collection c are found within this list.
	*/
	public boolean containsAll(Collection<?> c) {
		for (Object o : c) {
			if (!contains(o)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	* @param o The object to which to compare this list.
	* @return Returns true if Object o is a DoublyLinkedList of equal size and containing the same
	* elements as this DoublyLinkedList.
	*/
	public boolean equals(Object o) {
		if (o instanceof DoublyLinkedList && size == ((DoublyLinkedList) o).size()) {
			ListNode thisCurrent = front.next;
			ListNode otherCurrent = ((DoublyLinkedList) o).front.next;
			for (int i = 0; i < size; i++) {
				if (!thisCurrent.data.equals(otherCurrent.data)) {
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
	* @param o The object whose last index in this list is to be found.
	* @return Returns the last index of Object o within this list, return -1 if not found.
	*/
	public int lastIndexOf(Object o) {
		ListNode current = back.prev;
		for (int i = size - 1; i >= 0; i--) {
			if (current.data.equals(o)) {
				return i;
			}
			current = current.prev;
		}
		return -1;
	}
	
	/**
	* @param o The object to be removed from this list at its first found occurence.
	* @return Returns true if Object o is found in this list and subsequently removed.
	*/
	public boolean remove(Object o) {
		if (indexOf((E) o) >= 0) {
			remove(indexOf((E) o));
			return true;
		}
		return false;
	}
	
	/**
	* @param c The collection whose values are to be removed from this list.
	* @return Returns true if this list is changed, otherwise returns false.
	*/
	public boolean removeAll(Collection<?> c) {
		boolean changed = false;
		for (Object o : c) {
			while (contains(o)) {
				changed = true;
				remove(o);
			}
		}
		return changed;
	}
	
	/**
	* @param c The collection whose values are to be retained in this list.
	* @return Returns true if this list is changed, returns false otherwise.
	*/
	public boolean retainAll(Collection<?> c) {
		boolean changed = false;
		for (E value : this) {
			if (!c.contains(value)) {
				changed = true;
				remove(value);
			}
		}
		return changed;
	}
	
	/**
	* @return Returns an Object array containing all the elements found in this list.
	*/
	public Object[] toArray() {
		Object[] a = new Object[size];
		ListNode current = front.next;
		for (int i = 0; i < size; i++) {
			a[i] = current.data;
			current = current.next;
		}
		return a;
	}
	
	/**
	* @param newFront The first index of the new list.
	* @param newBack The end (non-inclusive) of the new list.
	* @return Returns a new DoublyLinkedList containing values found in this list from 
	* index newFront(inclusive) to index newBack (non-inclusive).
	*/
	public List<E> subList(int newFront, int newBack) {
		DoublyLinkedList sublist = new DoublyLinkedList();
		sublist.front.next = nodeAt(newFront);
		sublist.back = nodeAt(newBack);
		sublist.size = (newBack - newFront);
		return sublist;
	}
	
	/**
	* @param a The array to be filled with the elements found in this list.
	* @return Returns an array of type T containing all the elements found in this list.
	*/
	public <T> T[] toArray(T[] a) {
		ListNode current = front;
		for (int i = 0; i < size; i++) {
			a[i] = (T) current.data;
			current = current.next;
		}
		return a;
	} 
	
	
// List Node
	private static class ListNode<E> {
		public E data;
		public ListNode<E> next;
		public ListNode<E> prev;
		
		/**
		* @param data Data to be included in this ListNode.
		*/
		public ListNode(E data) {
			this(data, null, null);
		}
		
		/**
		* @param data Data to be included in this ListNode.
		* @param next The next ListNode.
		* @param prev The previous ListNode.
		*/
		public ListNode(E data, ListNode<E> next, ListNode<E> prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
	}
	
	
// List Iterator
	private class LinkedListIterator implements ListIterator<E> {
		private ListNode<E> current;
		private boolean removeOK;
		
		/**
		*
		*/
		public LinkedListIterator() {
			current = front.next;
			removeOK = false;
		}
		
		/**
		* @return Returns true if this list contains more elements in the forward direction.
		*/
		public boolean hasNext() {
			return current != back;
		}
		
		/**
		* @return Returns the next element in this list.
		* @throws NoSuchElementException if there is no next element.
		*/
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			E result = current.data;
			current = current.next;
			removeOK = true;
			return result;
		}
		
		/**
		* @throws IllegalStateException if add() or remove() has been called since next() or previous()
		* has last been called.
		*/
		public void remove() {
			if (!removeOK) {
				throw new IllegalStateException();
			}
			ListNode<E> prev2 = current.prev.prev;
			prev2.next = current;
			current.prev = prev2;
			size--;
			removeOK = false;
		}
		
		/**
		* @param e The element to be added to this list at the iterator's current position.
		*/
		public void add(E e) {
			DoublyLinkedList.this.add(nextIndex(), e);
			removeOK = false;
		}
		
		/**
		* @return Returns true if more elements exist in the list in the reverse direction. Returns
		* false if the iterator is at the beginning of the list.
		*/
		public boolean hasPrevious() {
			return current.prev != front;
		}
		
		/**
		* @return Returns the index of the next element that would be returned by a call to next().
		*/
		public int nextIndex() {
			ListNode getIndex = front;
			int index = 0;
			while (getIndex.next != current) {
				getIndex = getIndex.next;
				index++;
			}
			return index;
		}
		
		/**
		* @return Returns the previous element in the list.
		* @throws NoSuchElementException if the iterator is at the beginning of the list.
		*/
		public E previous() {
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}
			current = current.prev;
			E result = current.data;
			removeOK = true;
			return result;
		}
		
		/**
		* @return Returns the index of the element that would be returned by a call to previous().
		*/
		public int previousIndex() {
			ListNode getIndex = back;
			int index = size - 1;
			while (getIndex != current) {
				getIndex = getIndex.prev;
				index--;
			}
			return index;
		}
		
		/**
		* @param e The element which will replace the last element returned by previous() or next().
		*/
		public void set(E e) {
			DoublyLinkedList.this.set(nextIndex(), e);
			removeOK = false;
		}		
	}
	
// Iterator
	private class LinkedIterator implements Iterator<E> {
		private ListNode<E> current;
		private boolean removeOK;
		
		/**
		*
		*/
		public LinkedIterator() {
			current = front.next;
			removeOK = false;
		}
		
		/**
		* @return Returns true if the iterator has not reached the end of the list.
		*/
		public boolean hasNext() {
			return current != back;
		}
		
		/**
		* @return Returns the next element in this list.
		* @throws NoSuchElementException if the iterator has reached the end of the list.
		*/
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			E result = current.data;
			current = current.next;
			removeOK = true;
			return result;
		}
		
		/**
		* @throws IllegalStateException if either add() or remove() has been called since next() 
		* or previous() was last called.
		*/
		public void remove() {
			if (!removeOK) {
				throw new IllegalStateException();
			}
			ListNode<E> prev2 = current.prev.prev;
			prev2.next = current;
			current.prev = prev2;
			size--;
			removeOK = false;
		}
	}
}