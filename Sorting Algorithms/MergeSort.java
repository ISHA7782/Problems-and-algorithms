
public class MergeSort {

	public int[] sortt(int arr[])
	{
		mergeSort(arr,0,arr.length-1);		
		return arr;
	}
	void mergeSort(int arr[], int left, int right)
	{
		if(left<right)
		{
			int med = (left +right)/2;
			mergeSort(arr, left , med);
			mergeSort(arr, med+1, right);
			merge(arr, left , med, right);
		}
	}
	void merge(int arr[], int left, int med , int right)
	{
		
		 
		int left_size = med - left +1; 
		int left_arr[] = new int[left_size];
		
		int right_size = right - med;
		int right_arr[] = new int[right_size];
		
		for(int i =0; i<left_size ;i++)
			left_arr[i]= arr[left + i];
		
		for(int j=0; j<right_size; j++)
			right_arr[j] = arr[med + 1 +j];
		
		int i = 0,j=0;
		int position = left;
		while(i<left_size && j<right_size)
		{
			if(left_arr[i] > right_arr[j])
			{ 
				arr[position] = right_arr[j];
				j++;
			}
			else
			{
				arr[position] = left_arr[i];
				i++;
			}
			position++;
		}
		
		if(i == left_size)
		{
			while(position <= right)
			{
				arr[position] = right_arr[j];
				j++;
				position++;
			}
		}
		else
		{
			while(position <= right)
			{
				arr[position] = left_arr[i];
				i++;
				position++;
			}
		}
		
	}
	

}
