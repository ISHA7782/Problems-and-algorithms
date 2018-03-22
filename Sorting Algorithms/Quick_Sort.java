public class Quick_Sort {
	public int[] sortt(int arr[])
	{
		quickSort(arr, 0 , arr.length - 1);		
		return arr;
	}
	void quickSort(int arr[] , int left, int right)
	{
		if (left < right)
		{
			int position = partition(arr, left, right);
			
			quickSort(arr, left, position -1);
			quickSort(arr, position +1 , right);
		}
	}
	int partition(int arr[], int left, int right)
	{
		MySwap s_obj = new MySwap();
		int element = arr[right];
		int low = left -1 ;
		int i = left;
		while(i < right)
		{
			if(arr[i] <= element)
			{
				low++;
				s_obj.Swap(arr, low, i);
			}
			i++;
			
		}
		s_obj.Swap(arr, low+1 , right);
		return low+1;
	}
}
