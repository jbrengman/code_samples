/* Jordan Brengman
	ENGR 143
	HW 7 ArrayList<E> Iterator */


	import java.util.*;
	public class ArrayListIterator {
		
	// Fields
		private ArrayList list;
		private int position;
		private boolean removeOK;
		
		
	// Constructor
		public ArrayListIterator(ArrayList list) {
			this.list = list;
			position = 0;
			removeOK = false;
		}
		
		
	// Methods
		public void add(Object o) {
			list.checkCapacity(list.size() + 1);
			list.add(position, o);
			position++;
			removeOK = false;
		}
		
		public boolean hasNext() {
			return position < list.size();
		}
		
		public boolean hasPrevious() {
			return position > 0;
		}
		
		public Object next() {
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
		
		public Object previous() {
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
		
		public void set(Object o) {
			if (!removeOK) {
				throw new IllegalStateException();
			}
			list.set(position, o);
		}
		
	}
