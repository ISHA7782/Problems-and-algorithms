
public class Bubble_Sort {
	public int[] sortt(int arr[])
	{
		MySwap s_obj = new MySwap();
		int arr_size = arr.length;
		for(int i = 0; i < arr_size; i++ )
		{
			for(int j = i+1; j < arr_size; j++)
			{
				if(arr[i]>arr[j])
				{
					s_obj.Swap(arr, i, j);
				}
			}
						
		}
		return arr;
	}

}
