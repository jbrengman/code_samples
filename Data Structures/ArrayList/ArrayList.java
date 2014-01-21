/* Jordan Brengman
	ENGR 143
	HW 7 ArrayList<E> */
	

import java.util.*;	
public class ArrayList<E> {

// Fields

	private E[] list;
	private int size;
	
	public static final int DEFAULT_CAPACITY = 10;
	

// Constructors

	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException();
		}
		list = (E[]) new Object[capacity];
		size = 0;
	}
	
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}


// Methods


// Methods already implemented in chapter 15:
	
	public void add(E e) {
		checkCapacity(size + 1);
		list[size] = e;
		size++;
	}
	
	// Precondition: 0 <= index < size
	public void add(int index, E e) {
		checkIndex(index);
		checkCapacity(size + 1);
		for (int i = size; i > index; i--) {
			list[i] = list[i - 1];
		}
		list[index] = e;
		size++;
	}
	
	public String toString() {
		if (size == 0) {
			return "[]";
		} else {
			String result = "[" + list[0];
			for (int i = 1; i < size; i++) {
				result += ", " + list[i];
			}
			result += "]";
			return result;
		}
	}
	
	// Precondition: 0 <= index < size
	public void remove(int index) {
		checkIndex(index);
		for (int i = index; i < size - 1; i++) {
			list[i] = list[i + 1];
		}
		size--;
		list[size] = null;
	}
	
	public int size() {
		return size;
	}
	
	// Precondition: 0 <= index < size
	public E get(int index) {
		checkIndex(index);
		return list[index];
	}
	
	public void set(int index, E e) {
		checkIndex(index);
		list[index] = e;
	}
	
	public int indexOf(E e) {
		for (int i = 0; i < size; i++) {
			if (list[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean contains(E e) {
		return indexOf(e) >= 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	private void checkIndex(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public void checkCapacity(int capacity) {
	// double in size until large enough
		while (capacity > list.length) {
			list = Arrays.copyOf(list, 2 * list.length);
		}
	}


	
// "New" methods:
	
	// Precondition: 0 <= index < size
	public void addAll(int index, ArrayList<E> other) {
		checkIndex(index);
		checkCapacity(size + other.size());
		for (int i = 0; i < other.size(); i++) {
			add(index + i, other.get(i));
		}
	}
	
	public boolean containsAll(ArrayList<E> other) {
		for (int i = 0; i < other.size(); i++) {
			if (!contains(other.get(i))) {
				return false;
			}
		}
		return true;
	}
	
	public boolean equals(Object o) {
		if (o instanceof ArrayList && size == ((ArrayList) o).size()) {
			ArrayList<E> other = (ArrayList) o;
			for (int i = 0; i < size; i++) {
				if (!list[i].equals(other.get(i))) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	public int lastIndexOf(Object o) {
		for (int i = size - 1; i >= 0; i--) {
			if (list[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean remove(Object o) {
		for (int i = 0; i < size; i++) {
			if (list[i].equals(o)) {
				remove(i);
				return true;
			}
		}
		return false;
	}
	
	public void removeAll(ArrayList<E> other) {
		for (int i = size - 1; i >= 0; i--) {
			if (other.contains(list[i])) {
				remove(i);
			}
		}
	}
	
	public void retainAll(ArrayList<E> other) {
		for (int i = size - 1; i >= 0; i--) {
			if (!other.contains(list[i])) {
				remove(i);
			}
		}	
	}
	
	public Object[] toArray() {
		Object[] array = new Object[size];
		for (int i = 0; i < size; i++) {
			array[i] = list[i];
		}
		return array;
	}
	
	public ArrayListIterator iterator() {
		return new ArrayListIterator(this);
	}


/*
// Iterator

	private class ArrayListIterator implements ListIterator<E> {
		
	// Fields
		private int position;
		private boolean removeOK;
		
		
	// Constructor
		public ArrayListIterator() {
			position = 0;
			removeOK = false;
		}
		
		
	// Methods
		public void add (E e) {
			checkCapacity(size + 1);
			ArrayList.this.add(position, e);
			position++;
			removeOK = false;
		}
		
		public boolean hasNext() {
			return position < size();
		}
		
		public boolean hasPrevious() {
			return position > 0;
		}
		
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			position++;
			removeOK = true;
			return list[position - 1];
		}
		
		public int nextIndex() {
			return position;
		}
		
		public E previous() {
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}
			position--;
			removeOK = true;
			return list[position];
		}
		
		public int previousIndex() {
			return position - 1;
		}
		
		public void remove() {
			if (!removeOK) {
				throw new IllegalStateException();
			}
			ArrayList.this.remove(position - 1);
			position--;
			removeOK = false;
		}
		
		public void set(E e) {
			ArrayList.this.set(position, e);
		}
		
	}
*/
}