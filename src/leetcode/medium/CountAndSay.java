package src.leetcode.medium;

public class CountAndSay {

	public static void main(String[] args)
	{
		CountAndSay obj=new CountAndSay();
		System.out.println(obj.countAndSay(2));
	}
	
	public String countAndSay(int n)
	 {
	 	String num="1";
	      System.out.println(num);
	 	for(int i=1;i<n;i++)
	 	{
	 		num=say(num);
	 		System.out.println(num);
	 	}
	 	
	 return num;	
	 }
	 	
	 public String say(String str)
	 {
	 String strOut="";
	 char c='\0';
	 int i=0;
	 int cnt=0;
	 				while(i<str.length())
	 				{
	 					cnt=1;
	 					c=str.charAt(i++);
	 					while(i<str.length() && c==str.charAt(i))
	 					{
	 						cnt++;
	 						if(i==str.length()-1)
	 						{
	 						strOut=strOut+cnt+c;
	 						return strOut;
	 						}	
	 					i++;	
	 					}
	 					strOut=strOut+cnt+c;	
	 				}
	 return strOut;
	 }
}
