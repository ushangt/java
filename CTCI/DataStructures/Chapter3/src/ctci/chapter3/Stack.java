package ctci.chapter3;

class Node {
	Node next = null;
	Object data;
	
	public Node(Object d) {
		data = d;
	}
	
	void appendToTail(Object d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
		
	Node deleteNode(Node head,Object d){
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

public class Stack {
	
	Node top;
	
	Object pop(){
		if(top != null){
			Object item = top.data;
			top = top.next;
			return item;
		}
		return null;
	}
	
	
	void push(Object item){
		Node t = new Node(item);
		t.next = top;
		top = t;
	}
	
	Object peek(){
		return top.data;
	}

}
