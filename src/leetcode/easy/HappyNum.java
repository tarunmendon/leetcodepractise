package src.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNum {

	public static void main(String[] args) {

		HappyNum obj=new HappyNum();
		System.out.println(obj.isHappyNumber(20));
	}

boolean isHappyNumber(int n)
{
Set<Integer> st=new HashSet<Integer>();	
	while (n!=1)
    {
        n = numSquareSum(n);
        System.out.println(n);
        if (n == 1)
            return true;
        if (!st.add(n))
        {
        	System.out.println(st);
            return false;
        }    
    }
return true;	
}
int numSquareSum(int n)
{
	int sum=0;
	
	while(n!=0)
	{
	sum=(int) (sum+Math.pow(n%10,2));	
		n=n/10;
	}
	//System.out.println("sum:"+sum);
return sum;	
}
}
