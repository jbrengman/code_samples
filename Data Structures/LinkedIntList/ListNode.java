/* Jordan Brengman
	ENGR 143
	LinkedIntList */
	
	
/**
* @author Jordan Brengman
*/
	
public class ListNode {

// Fields

	public int data;
	public ListNode next;
	
	
// Constructors

	/**
	*
	*/
	public ListNode() {
		this(0, null);
	}
	
	/**
	* @param data The integer to be contained within this ListNode.
	*/
	public ListNode(int data) {
		this(data, null);
	}
	
	/**
	* @param data The integer to be contained within this ListNode.
	* @param next The ListNode to which this ListNode will point.
	*/
	public ListNode(int data, ListNode next) {
		this.data = data;
		this.next = next;
	}
	
	
// Methods

}