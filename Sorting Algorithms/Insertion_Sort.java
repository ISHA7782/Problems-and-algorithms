
public class Insertion_Sort {
	public int[] sortt(int arr[])
	{
		int arr_size = arr.length;
		for(int i = 1; i < arr_size; i++ )
		{
			int temp = i;
			int j = i-1;
			while(arr[i]<=arr[j] && j >= 0)
			{
				temp = j;
				j--;
				if(j<0)
					break;
			}
			if(i != temp)
			arr=this.insert_element(arr, i , temp);
		}
		return arr;
	}
	public int[] insert_element(int arr[],int element_index, int new_index)
	{
		int temp = arr[element_index];
		int i = element_index;
		while(i>new_index)
		{
			arr[i]=arr[i-1];
			i--;
		}
		arr[new_index]=temp;
		return arr;
	}
}
