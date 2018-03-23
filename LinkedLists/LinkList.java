
public class LinkList {
	Node head;
	class Node
	{
		int data;
		Node next;
		Node(int data)
		{
			this.data = data;
			next = null;
		}
	}
	
	public void add_element(LinkList link, int element)
	{
		Node current = link.head;
		if(link.head == null)
		{
			head = new Node(element);
			return;
		}
		while(current.next != null)
		{
			current = current.next;
		}
		current.next = new Node(element);
	}
}
