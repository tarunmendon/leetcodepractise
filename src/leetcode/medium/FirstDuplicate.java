package src.leetcode.medium;

public class FirstDuplicate {

	public static void main(String args[])
	{
		int[] a=new int[] {2,1,3,5,3,2};
		FirstDuplicate obj=new FirstDuplicate();
		System.out.println(obj.firstDuplicate(a));
		
	}
	
	int firstDuplicate(int[] a)
	{
		for(int i=0;i<a.length;i++)
		{
			if(a[Math.abs(a[i])-1]<0)
			{
				return Math.abs(a[i]);
			}
			else
				a[Math.abs(a[i])-1]=-a[Math.abs(a[i])-1];
		}
		
	return -1;
	}
}
