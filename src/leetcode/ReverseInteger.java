package src.leetcode;

public class ReverseInteger {

	public static void main(String argsp[])
	{
		ReverseInteger reverse=new ReverseInteger();
		System.out.println(reverse.reverse(1534236469));//9646324351
	}
	
	 public int reverse(int x) {
			 int num=0;
		 int i=0;
		 try
		 {
		 while(x!=0)
		 {
			 int digit=x%10;
			 num=Math.multiplyExact(num, 10);
			 num=num+digit;
			 x=x/10;
		 }
		 }catch(ArithmeticException e)
		 {
			 return 0;
		 }
		 return num;
	    }
}
