
public class SelectionSort {

	public int[] sortt(int arr[])
	{
		int arr_size = arr.length;
		for(int i = 0; i < arr_size; i++ )
		{
			int temp = i;
			for(int j = i+1; j < arr_size; j++)
			{
				if(arr[temp]>arr[j])
				{
					temp = j;
				}
			}
			MySwap s_obj = new MySwap();
			s_obj.Swap(arr, i, temp);
			
		}
		return arr;
	}
}
