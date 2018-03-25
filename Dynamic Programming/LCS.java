
public class LCS {
	int find_length_of_lcs(char str1[], char str2[], int n , int m)
	{
		if(n==0 || m==0)
			return 0;
		else 
		{
			if (str1[n-1]==str2[m-1])
			{
				return (find_length_of_lcs(str1,str2,n-1,m-1) + 1);
			}
			else
			{
				return Math.max(find_length_of_lcs(str1,str2,n-1,m), find_length_of_lcs(str1,str2,n,m-1));
			}
		}
	}
	public static void main(String args[])
	{
		LCS obj = new LCS();
		String s1 = "ABCDEFHG";
		String s2 = "BCDABCDEFAH";
		char arr1[] = s1.toCharArray();
		char arr2[] = s2.toCharArray();
		
		int length = obj.find_length_of_lcs(arr1, arr2, arr1.length, arr2.length);
		System.out.println("Length of Longest common Subsequence is "+ length);
		
	}
}
