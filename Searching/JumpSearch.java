
public class JumpSearch {

	public void check(int []arr, int prev, int last, int element)
	{
		for( int i = prev; i <= last; i++ )
		{
			if(element == arr[i])
			{
				System.out.println(" Element found at " + element + " == " + i );
				return;
			}
				
		}
		System.out.println("Element not found");
	}
	public void jumpsearch(int arr[], int element)
	{
		int size = arr.length;
		int jumps = 3;
		int prev = 0 ;
		for(int i = 0 ; i <size; i = i +jumps)
		{
			if(arr[i] < element);
			else
			{
				if(i >= size)
				{
					check(arr, prev, size, element);
				}
				else
				{
					check(arr, prev, i, element);
				}
				break;

			}
			prev = i;
			}
	}
	public static void main(String args[])
	{
		int arr[] = { 0,1,2,3,6,8,9,10,13,14};
		JumpSearch obj = new JumpSearch();
		obj.jumpsearch(arr, 8);
	}
}
