package ctci.chapter2;
	
class Node {
	Node next = null;
	int data;
	
	public Node(int d) {
		data = d;
	}
	
	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
		
	Node deleteNode(Node head,int d){
		Node n = head;
		if(n.data == d)
			return head.next; 			/* move head */
		while(n.next!=null){
			if(n.next.data == d){
				n.next = n.next.next;
				return head; 			/* head didn't change */
			}
			n = n.next;
		}
		return head;
	}
}


