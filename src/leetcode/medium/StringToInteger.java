package src.leetcode.medium;

public class StringToInteger {

	public static void main(String[] args) {

	String s="-91283472332";
	StringToInteger obj=new StringToInteger();
	System.out.println(obj.myAtoi(s));
	}
	
	
	 public int myAtoi(String s) {
			int out=0,sign=1;
		 for(char c:s.toCharArray())
			{
				if(c=='+'||c=='-'||c==' ')
				{
					sign=(c=='-')?-1:1;
				}	
				else if(c>='0' && c<='9')
				{
					//Check for overflow as well
				try
				{
				out=Math.addExact(Math.multiplyExact(out,10),c-'0');
				}
				catch(ArithmeticException e)
				{
					return (sign==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
				}
				}
				else
					break;
			}
		 return out*sign;
	    }
}
