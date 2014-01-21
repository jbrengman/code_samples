/* Jordan Brengman
	ENGR 143
	HW 9 */
	
	
import java.util.*;
public class SearchTree<E extends Comparable<E>> {

/**
* @author Jordan Brengman
*/


// Fields

    private SearchTreeNode<E> overallRoot;


// Constructors

    public SearchTree() {
        overallRoot = null;
    }


// Methods

	// Methods from chapter 17
	
	/**
	* @param value The object to be added to the tree.
	*/
    public void add(E value) {
        overallRoot = add(overallRoot, value);
    }
	
	/**
	* @param root The root to which value is added.
	* @param value The object to be added to root.
	* @return Returns a SearchTreeNode<E> containing the added value.
	*/
    private SearchTreeNode<E> add(SearchTreeNode<E> root, E value) {
        if (root == null) {
            root = new SearchTreeNode<E>(value);
        } else if (root.data.compareTo(value) >= 0) {
            root.left = add(root.left, value);
        } else {
            root.right = add(root.right, value);
        }
        return root;
    }

	/**
	* @param value The value to be searched for within the tree.
	* @return Returns true if value is found in the tree, false otherwise.
	*/
    public boolean contains(E value) {
        return contains(overallRoot, value);
    }   

	/**
	* @param root The SearchTreeNode<E> being searched for value.
	* @param value The value being searched for within root.
	* @return Returns true if root contains value.
	*/
    private boolean contains(SearchTreeNode<E> root, E value) {
        if (root == null) {
            return false;
        } else {
            int compare = value.compareTo(root.data);
            if (compare == 0) {
                return true;
            } else if (compare < 0) {
                return contains(root.left, value);
            } else {
					return contains(root.right, value);
            }
        }
    }

	/**
	*
	*/
    public void print() {
        printInorder(overallRoot);
    }

	/**
	* @param root The SearchTreeNode<E> being printed.
	*/
    private void printInorder(SearchTreeNode<E> root) {
        if (root != null) {
            printInorder(root.left);
            System.out.println(root.data);
            printInorder(root.right);
        }
    }


// New methods

	/**
	* @param tree The SearchTree<E> whose values are to be added to this tree.
	*/
	public void addAll(SearchTree<E> tree) {
		addAll(tree.overallRoot);
	}
	
	/**
	* @param root The SearchTreeNode<E> whose values are to be added to this tree.
	*/
	private void addAll(SearchTreeNode<E> root) {
		if (root != null) {
			addAll(root.left);
			add(root.data);
			addAll(root.right);
		}
	}
	
	/**
	*
	*/
	public void clear() {
		overallRoot = null;
	}
	
	/**
	* @param tree The SearchTree<E> whose values are being searched for within this tree.
	* @return Returns true if this tree contains all valuese found within tree.
	*/
	public boolean containsAll(SearchTree<E> tree) {
		return containsAll(tree.overallRoot);
	}
	
	/**
	* @param root The SearchTreeNode<E> whose values are being searched for within this tree.
	* @return Returns true if this tree contains all values found within root.
	*/
	private boolean containsAll(SearchTreeNode<E> root) {
		if (root != null) {
			return (containsAll(root.left) && containsAll(root.right) && contains(root.data));
		}
		return true;
	}
	
	/**
	* @param o The object this tree is being compared to.
	* @return Returns true if o is a SearchTree<E> containing the same elements as this tree.
	*/
	public boolean equals(Object o) {
		if (o instanceof SearchTree) {
			return equals(overallRoot, ((SearchTree<E>) o).overallRoot);
		}
		return false;
	}
	
	/**
	* @param thisRoot SearchTreeNode<E> from this tree being compared to otherRoot.
	* @param otherRoot SearchTreeNode<E> from Object o being compared to thisRoot.
	* @return Returns true if thisRoot and otherRoot are 'equal', containing the same elements.
	*/
	private boolean equals(SearchTreeNode<E> thisRoot, SearchTreeNode<E> otherRoot) {
		if (thisRoot == null && otherRoot == null) {
			return true;
		}
		if (thisRoot != null && otherRoot != null) {
			return (equals(thisRoot.left, otherRoot.left) 
					&& equals(thisRoot.right, otherRoot.right)
					&& thisRoot.data.equals(otherRoot.data));
		}
		return false; // Catches cases where this tree and other tree are of different sizes
	}
	
	/**
	* @return Returns true if this tree contains no elements, false otherwise.
	*/
	public boolean isEmpty() {
		return overallRoot == null;
	}
	
	/**
	* @param o The object to be removed from this tree at its first found occurence.
	* @return Returns true if o is found in this tree and subsequently removed.
	*/
	public boolean remove(Object o) {
		if (overallRoot.data.equals(o)) {
			SearchTree<E> newTree = new SearchTree<E>();
			newTree.addAll(overallRoot.left);
			newTree.addAll(overallRoot.right);
			overallRoot = newTree.overallRoot;
			return true;
		} else {
			return remove(overallRoot, o);
		}
	}
	
	/**
	* @param root The root being searched for o.
	* @param o The object being searched for and to be removed from root.
	* @return Returns true if o is found in root and subsequently removed.
	*/
	private boolean remove(SearchTreeNode<E> root, Object o) {
		if (root.left != null) {
			if (root.left.data.equals(o)) {
				SearchTreeNode<E> left = root.left.left;
				SearchTreeNode<E> right = root.left.right;
				root.left = null;
				addAll(left);
				addAll(right);
				return true;
			}
		} if (root.right != null) {
			 if (root.right.data.equals(o)) {
				SearchTreeNode<E> left = root.right.left;
				SearchTreeNode<E> right = root.right.right;
				root.right = null;
				addAll(left);
				addAll(right);
				return true;
			}
			return (remove(root.right, o) || remove(root.left, o));
		}
		return false;
	}
	
	/**
	* @param tree The SearchTree<E> whose values will be removed from this tree.
	*/
	public void removeAll(SearchTree<E> tree) {
		removeAll(tree.overallRoot);
	}
	
	/**
	* @param root The SearchTreeNode<E> whose values will be removed from this tree.
	*/
	private void removeAll(SearchTreeNode<E> root) {
		if (root != null) {
			removeAll(root.left);
			removeAll(root.right);
			while (contains(root.data)) {
				remove(root.data);
			}
		}
	}
	
	/**
	* @param tree The SearchTree<E> whose values will be retained within this tree.
	*/
	public void retainAll(SearchTree<E> tree) {
		retainAll(overallRoot, tree);
	}
	
	/**
	* @param root The root from which values not contained in tree will be removed.
	* @param tree The SearchTree<E> whose values will be retained within root.
	*/
	private void retainAll(SearchTreeNode<E> root, SearchTree<E> tree) {
		if (root != null) {
			retainAll(root.left, tree);
			retainAll(root.right, tree);
			if (!tree.contains(root.data)) {
				remove(root.data);
			}
		}
	}
	
	/**
	* @return Returns an Object[] containing the same elements as this tree. 
	*/
	public Object[] toArray() {
		ArrayList<Object> a = new ArrayList<Object>();
		toArray(overallRoot, a);
		return a.toArray();
	}
	
	/**
	* @param root The SearchTreeNode<E> whose elements are added to a.
	* @param a ArrayList<Object> to which all elements from root are added.
	*/
	private void toArray(SearchTreeNode<E> root, ArrayList<Object> a) {
		if (root != null) {
			toArray(root.left, a);
			toArray(root.right, a);
			a.add(root.data);
		}
	}
	
	/**
	* @return Returns the number of elements within this tree.
	*/
	public int size() {
		return size(overallRoot, 0);
	}
	
	/**
	* @param root The SearchTreeNode<E> whose elements are being counted.
	* @param size The current count of elements in this tree.
	* @return Returns The number of elements found in root.
	*/
	private int size(SearchTreeNode<E> root, int size) {
		if (root != null) {
			return 1 + size(root.left, size) + size(root.right, size);
		}
		return size;
	}
	
	/**
	* @return Returns a new SearchTreeIterator.
	*/
	public SearchTreeIterator iterator() {
		return new SearchTreeIterator(this);
	}




    private static class SearchTreeNode<E> {

        public E data;
        public SearchTreeNode<E> left;
        public SearchTreeNode<E> right;
		  public SearchTreeNode<E> parent;

        public SearchTreeNode(E data) {
            this(data, null, null);
        }

        public SearchTreeNode(E data, SearchTreeNode<E> left,
                              SearchTreeNode<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }




	private class SearchTreeIterator implements Iterator<E> {

// Fields

		private SearchTree<E> tree;
		private SearchTreeNode<E> currentRoot;
		private int position;
	
	
// Constructor

		public SearchTreeIterator(SearchTree<E> tree) {
			this.tree = tree;
			currentRoot = tree.overallRoot;
			position = 0;
			assignParents();
		}
		
// Methods

		/**
		* @return Returns true if the iterator has not reached the end of the tree, false otherwise.
		*/
		public boolean hasNext() {
			return position < tree.size();
		}		

		/**
		* @return Returns the next element in the tree.
		*/
		public E next() {
			assignParents();
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			if (position == 0) {
				position++;
				return currentRoot.data;
			}
			if (currentRoot.left != null) {
				position++;
				currentRoot = currentRoot.left;
				return currentRoot.data;
			}
			if (currentRoot.parent.right != null) {
				position++;
				currentRoot = currentRoot.parent.right;
				return currentRoot.data;
			}
			while (currentRoot.parent.right == null) {
				currentRoot = currentRoot.parent;
			}
			position++;
			currentRoot = currentRoot.right;
			return currentRoot.data;
		}
		
		/**
		*
		*/
		public void remove() {
			SearchTreeNode<E> left = currentRoot.left;
			SearchTreeNode<E> right = currentRoot.right;
			if (currentRoot == currentRoot.parent.left) {
				currentRoot.parent.left = null;
			} else if (currentRoot == currentRoot.parent.right) {
				currentRoot.parent.right = null;
			}
			addAll(left);
			addAll(right);
		}
			
		/**
		*
		*/
		private void assignParents() {
			assignParents(overallRoot);
		}
		
		/**
		* @param root The SearchTreeNode<E> whose child nodes are to be assigned root as their parent node.
		*/
		private void assignParents(SearchTreeNode<E> root) {
			if (root.left != null) {
				root.left.parent = root;
				assignParents(root.left);
			}
			if (root.right != null) {
				root.right.parent = root;
				assignParents(root.right);
			}
		}
	}
}