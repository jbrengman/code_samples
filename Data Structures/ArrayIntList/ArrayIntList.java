/* Jordan Brengman
	ENGR 143
	HW 7 ArrayIntList */
	
/**
* @author Jordan Brengman
*/
import java.util.*;	
public class ArrayIntList implements IntList {

// Fields

	private int[] list;
	private int size;
	
	public static final int DEFAULT_CAPACITY = 10;


// Constructors

/**
* @param capacity The capacity of the ArrayIntList to be constructed.
* @throws IllegalArgumentException If the initial capacity is less than zero.
*/
	public ArrayIntList(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException();
		}
		list = new int[capacity];
		size = 0;
	}
	
	public ArrayIntList() {
		this(DEFAULT_CAPACITY);
	}


// Methods


// Methods already implemented in chapter 15:

/**
* @param value The value to be added to the end of the ArrayIntList.
*/	
	public void add(int value) {
		checkCapacity(size + 1);
		list[size] = value;
		size++;
	}
	
/**
* @param index The index at which the specified value is to be added.
* @param value The value to be added at the specified index.
*/	
	// Precondition: 0 <= index < size
	public void add(int index, int value) {
		checkIndex(index);
		checkCapacity(size + 1);
		for (int i = size; i > index; i--) {
			list[i] = list[i - 1];
		}
		list[index] = value;
		size++;
	}

/**
* @return Returns a string representation of the ArrayIntList.
*/		
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

/**
* @param index The index at which the current value is to be removed.
*/		
	// Precondition: 0 <= index < size
	public void remove(int index) {
		checkIndex(index);
		for (int i = index; i < size - 1; i++) {
			list[i] = list[i + 1];
		}
		size--;
		list[size] = 0;
	}

/**
* @return Returns the number of elements in the ArrayIntList.
*/		
	public int size() {
		return size;
	}

/**
* @param index The index of the value to be returned.
* @return Returns the value found at the specified index.
*/		
	// Precondition: 0 <= index < size
	public int get(int index) {
		checkIndex(index);
		return list[index];
	}

/**
* @param index The index that is to have its value set.
* @param value The value to be assigned to the specified index.
*/		
	public void set(int index, int value) {
		checkIndex(index);
		list[index] = value;
	}

/**
* @param value The value whose index is to be found.
* @return Returns the first index of value, or -1 if the value is not found.
*/		
	public int indexOf(int value) {
		for (int i = 0; i < size; i++) {
			if (list[i] == value) {
				return i;
			}
		}
		return -1;
	}

/**
* @param value The value to look for in this ArrayIntList. 
* @return boolean Returns true if value is found in the ArrayIntList, false otherwise.
*/		
	public boolean contains(int value) {
		return indexOf(value) >= 0;
	}

/**
* @return Returns true if the ArrayIntList contains zero elements, false otherwise.
*/		
	public boolean isEmpty() {
		return size == 0;
	}

/**
* @param index The index to check if it exists in the ArrayIntList.
* @throws IndexOutOfBoundsException if the given index is outside the range of the ArrayIntList.
*/		
	private void checkIndex(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
	}

/**
* @param capacity The minimum desired capacity of the ArrayIntList.
*/		
	public void checkCapacity(int capacity) {
		while (capacity > list.length) {
			list = Arrays.copyOf(list, 2 * list.length);
		}
	}


	
// "New" methods:

/**
* @param index The index at which the ArrayIntList other is to be added.
* @param other The ArrayIntList to be added at the specified index.
*/		
	// Precondition: 0 <= index < size
	public void addAll(int index, ArrayIntList other) {
		checkIndex(index);
		checkCapacity(size + other.size());
		for (int i = 0; i < other.size(); i++) {
			add(index + i, other.get(i));
		}
	}

/**
* @param other The ArrayIntList to compare this ArrayIntList to.
* @return Returns true if this ArrayIntList contains all values within the ArrayIntList 
* other, false otherwise.
*/		
	public boolean containsAll(ArrayIntList other) {
		for (int i = 0; i < other.size(); i++) {
			if (!contains(other.get(i))) {
				return false;
			}
		}
		return true;
	}

/**
* @param o The object to compare this ArrayIntList to.
* @return Returns true if Object o is an ArrayIntList of equal size to and containing the same
* elements at the same indexes as this ArrayIntList, false otherwise.
*/		
	public boolean equals(Object o) {
		if (o instanceof ArrayIntList && size == ((ArrayIntList) o).size()) {
			ArrayIntList other = ((ArrayIntList) o);
			for (int i = 0; i < size; i++) {
				if (list[i] != other.get(i)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

/**
* @param value The value whose last index is to be found.
* @return Returns the last index of the specified value within this ArrayIntList, or -1 if 
* value is not found.
*/		
	public int lastIndexOf(int value) {
		for (int i = size - 1; i >= 0; i--) {
			if (list[i] == value) {
				return i;
			}
		}
		return -1;
	}

/**
* @param o The Object to be removed from this ArrayIntList.
* @return Returns true if Object o is found in and removed from this ArrayIntList, otherwise returns
* false.
*/		
	public boolean removeValue(int value) {
		for (int i = 0; i < size; i++) {
			if (list[i] == value) {
				remove(i);
				return true;
			}
		}
		return false;
	}

/**
* @param other The ArrayIntList whose values will be removed from this ArrayIntList.
*/		
	public void removeAll(ArrayIntList other) {
		for (int i = size - 1; i >= 0; i--) {
			if (other.contains(list[i])) {
				remove(i);
			}
		}
	}

/**
* @param other The ArrayIntList whose values will be retained in this ArrayIntList.
*/		
	public void retainAll(ArrayIntList other) {
		for (int i = size - 1; i >= 0; i--) {
			if (!other.contains(list[i])) {
				remove(i);
			}
		}	
	}

/**
* @return Returns an integer array containing the same elements at the same indexes as this ArrayIntList.
*/		
	public int[] toArray() {
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = list[i];
		}
		return array;
	}

/**
* @return Returns an ArrayIntListIterator.
*/		
	public ArrayIntListIterator iterator() {
		return new ArrayIntListIterator(this);
	}


} 
