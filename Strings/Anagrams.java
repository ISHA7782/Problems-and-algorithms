import java.util.Arrays;

public class Anagrams {
	public static void main(String args[])
	{
		String str1 = "ishaarora";
		String str2 = "ahoraahsi";
		
		checkAnagram(str1,str2);
	}
	static void checkAnagram(String str1, String str2)
	{
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
	
		int size1 = arr1.length;
		int size2 = arr2.length;
		
		int count1[] = new int[256];
		int count2[] = new int[256];
		Arrays.fill(count1, 0);
		Arrays.fill(count2, 0);
		
		for(int i = 0 ; i < size1 && i <size2 ;i++)
		{
			count1[arr1[i]]++;
			count2[arr2[i]]++;
		}
		
		if(size1 != size2)
		{
			System.out.println("Not anagrams");
			return;
		}
		
		for( int i = 0 ; i < 256; i++)
		{
			if (count1[i] != count2[i])
			{
				System.out.println("Not anagrams");
				return;
			}
		}
		System.out.println("Anagrams");
	}
}
