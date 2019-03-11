package sxt;

public class Node {
	
	
	Node  previous;		//��һ���ڵ�
	Node next;				//��һ���ڵ�
	
	
	Object element;		//Ԫ������
	
	
	
	public Node(Node previous, Node next, Object element) {
		super();
		this.previous = previous;
		this.next = next;
		this.element = element;
	}



	public Node(Object element) {
		super();
		this.element = element;
	}
	
	
	
	
}
