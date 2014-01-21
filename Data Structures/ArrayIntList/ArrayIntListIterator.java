/* Jordan Brengman
	ENGR 143
	HW 7 ArrayIntListIterator */
	
	
	import java.util.*;
	public class ArrayIntListIterator {
		
	// Fields
		private ArrayIntList list;
		private int position;
		private boolean removeOK;
		
		
	// Constructor	
		public ArrayIntListIterator(ArrayIntList list) {
			this.list = list;
			position = 0;
			removeOK = false;
		}
		
		
	// Methods
		public void add (int value) {
			list.checkCapacity(list.size() + 1);
			list.add(position, value);
			position++;
			removeOK = false;
		}
		
		public boolean hasNext() {
			return position < list.size();
		}
		
		public boolean hasPrevious() {
			return position > 0;
		}
		
		public int next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			position++;
			removeOK = true;
			return list.get(position - 1);
		}
		
		public int nextIndex() {
			return position;
		}
		
		public int previous() {
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}
			position--;
			removeOK = true;
			return list.get(position);
		}
		
		public int previousIndex() {
			return position - 1;
		}
		
		public void remove() {
			if (!removeOK) {
				throw new IllegalStateException();
			}
			list.remove(position - 1);
			position--;
			removeOK = false;
		}
		
		public void set(int value) {
			if (!removeOK) {
				throw new IllegalStateException();
			}
			list.set(position, value);
		}
		
	}