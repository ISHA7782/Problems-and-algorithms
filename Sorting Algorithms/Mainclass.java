
public class Mainclass {
	public static void main(String args[])
	{
		int arr[] = {2,3,4,5,10,1,0,15,7,12,100,2,1,8};
		int arr1[] = {2,3,4,5,10,1,0,15,7,12,100,2,1,8};
		int arr2[] = {2,3,4,5,10,1,0,15,7,12,100,2,1,8};
		int arr3[] = {2,3,4,5,10,1,0,15,7,12,100,2,1,8};
		int arr4[] = {2,3,4,5,10,1,0,15,7,12,100,2,1,8};

		Mainclass main_obj = new Mainclass();
		main_obj.Selection_sort(arr);
		main_obj.Bubble_sort(arr1);
		main_obj.Insertion_sort(arr2);
		main_obj.Merge_sort(arr3);
		main_obj.Quick_sort(arr3);
	}
	
	void add_extra_space()
	{
		System.out.println();
		System.out.println("-----------------------------------------------------------");
	}
	void print_arr(int arr[])
	{
		for(int num : arr)
		{
			System.out.print(num+ "  ");
		}
		
	}
	void Selection_sort(int arr[])
	{
		SelectionSort Selection_obj = new SelectionSort();
		int sort_arr[] = Selection_obj.sortt(arr);
		System.out.println("Sorted array after Selection Sort");
		this.print_arr(sort_arr);
	}
	void Bubble_sort(int arr[])
	{
		Bubble_Sort Bubble_obj = new Bubble_Sort();
		int sort_arr[] = Bubble_obj.sortt(arr);
		this.add_extra_space();
		System.out.println("Sorted array after Bubble Sort");
		this.print_arr(sort_arr);
	}
	void Insertion_sort(int arr[])
	{
		Insertion_Sort Insertion_obj = new Insertion_Sort();
		int sort_arr[] = Insertion_obj.sortt(arr);
		this.add_extra_space();
		System.out.println("Sorted array after Insertion Sort");
		this.print_arr(sort_arr);
	}
	void Merge_sort(int arr[])
	{
		MergeSort Merge_obj = new MergeSort();
		int sort_arr[] = Merge_obj.sortt(arr);
		this.add_extra_space();
		System.out.println("Sorted array after Merge Sort");
		this.print_arr(sort_arr);
	}
	void Quick_sort(int arr[])
	{
		Quick_Sort Quick_obj = new Quick_Sort();
		int sort_arr[] = Quick_obj.sortt(arr);
		this.add_extra_space();
		System.out.println("Sorted array after Quick Sort");
		this.print_arr(sort_arr);
	}
}
