
public class MySwap {
	public int[] Swap(int arr[], int i , int j)
	{
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		return arr;
	}

}
