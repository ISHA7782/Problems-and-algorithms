// To calculate if nodes have total even or odd number of nodes 
public class EvenOddNumberOfNodes {
	public static void main(String args[])
	{
		LinkList l = new LinkList();
		l.add_element(l, 1);
		l.add_element(l, 2);
		l.add_element(l, 3);
		l.add_element(l, 4);
		l.add_element(l, 5);
		l.add_element(l, 6);
		l.add_element(l, 6);


		EvenOddNumberOfNodes obj = new EvenOddNumberOfNodes();
		obj.calculate_if_total_nodes_are_even_odd(l);
	}
	public void calculate_if_total_nodes_are_even_odd(LinkList l)
	{
		LinkList.Node current = l.head;
		
		while(current !=null && current.next!=null)
		{
			if(current.next.next == null)
			{
				System.out.println("Number of nodes in Linklist are even");
				return;
			}
			current = current.next.next;
		}
		System.out.println("Number of nodes in Linklist are odd");

	}

}
