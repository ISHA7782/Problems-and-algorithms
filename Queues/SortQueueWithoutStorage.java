import java.util.LinkedList;

public class SortQueueWithoutStorage {
	@SuppressWarnings("rawtypes")
	public static void main(String args[])
	{
		@SuppressWarnings("unchecked")
		LinkedList<Integer> queue = new LinkedList();
		queue.addLast(2);
		queue.addLast(1);
		queue.addLast(3);
		queue.addLast(8);
		queue.addLast(4);
		
		SortQueueWithoutStorage obj = new SortQueueWithoutStorage();

		obj.sort(queue);
		System.out.print("\n *********  Sorted Queue ************");

		obj.print(queue);
		
	}
	public void sort(LinkedList<Integer> queue)
	{
		int n = queue.size();
		for(int k= 0; k< n; k++)
		{
			System.out.print("\n Before "+ k +" Iterationn -   ");
			print(queue);

			int index = get_min(queue, k);
			queue = add_min_element_to_rear(queue, index, k);
		}
	}
	public int get_min(LinkedList<Integer> queue, int minimum_sorted_index)
	{

		int size = queue.size();
		int small_element = 9999999;
		int index = -1;
		int current;
		for(int j = 0; j< size ; j++)
		{
			

			current = queue.pollFirst();
			if(small_element > current &&  j< size - minimum_sorted_index)
			{
				small_element = current;
				index = j;
			}
			queue.addLast(current);
		}
		return index;
		
	}
	public LinkedList<Integer> add_min_element_to_rear(LinkedList<Integer> queue, int index , int max)
	{
		int min_element = 99999 , current=999999;
		int sizee = queue.size();
		for(int i = 0; i < sizee; i++)
		{
			current = queue.pollFirst();
			if(i == index && i<sizee - max )
			{
				min_element = current; 

			}
			else
			{
				queue.addLast(current);
			}
		}
		queue.addLast(min_element);
		return queue;
	}
	public void print(LinkedList<Integer> queue)
	{
		int n = queue.size();
		System.out.print(" \n Queue - ");
		for(int m = 0; m < n; m++ )
		{
			int current = queue.pollFirst();
			System.out.print(current + " ");
			queue.addLast(current);
		}
	}
}

