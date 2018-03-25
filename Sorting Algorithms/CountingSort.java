
public class CountingSort {
	public int[] sortt(int arr[])
	{
		int count[] =  new int[256];
		int length = arr.length;
		int output[] = new int[length];
		
		for (int i = 0; i < 256; i++ )
			count[i] = 0;
		
		for(int i = 0 ; i < length; i++)
			++count[arr[i]];
		
		for(int i = 1; i <256; i++)
			count[i] = count[i]+count[i-1];
		
		for(int i = 0 ; i < length; i ++)
		{
			output[count[arr[i]]-1] = arr[i];
			--count[arr[i]];
		}
		
		for(int i = 0 ; i < length ; i++)
		{
			arr[i] = output[i];
		}
		return arr;
	}
}
