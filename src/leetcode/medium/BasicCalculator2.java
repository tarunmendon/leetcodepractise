package src.leetcode.medium;

import java.util.Stack;

public class BasicCalculator2 {

	public static void main(String[] args) {
		BasicCalculator2 obj=new BasicCalculator2();
		//System.out.println(obj.calculate("3+2*2"));
		//System.out.println(obj.calculateWithStack("3+2*2"));
		System.out.println(obj.calculateWithStack("-32-2"));
	}
	public int calculate(String s) {
	    int md=-1; // 0 is m, 1 is d
	    int sign=1; // 1 is +, -1 is -
	    int prev=0;
	    int result=0;
	 
	    for(int i=0; i<s.length(); i++){
	        char c = s.charAt(i);
	        if(Character.isDigit(c)){
	            int num = c-'0';
	            while(++i<s.length() && Character.isDigit(s.charAt(i))){
	                num = num*10+s.charAt(i)-'0';
	            }
	            i--; // back to last digit of number
	 
	            if(md==0){
	                prev = prev * num;
	                md=-1;
	            }else if(md==1){
	                prev = prev / num;
	                md=-1;
	            }else{
	                prev = num;
	            }
	        }else if(c=='/'){
	            md=1;
	        }else if(c=='*'){
	            md=0;
	        }else if(c=='+'){
	            result = result + sign*prev;
	            sign=1;
	        }else if(c=='-'){
	            result = result + sign*prev;
	            sign=-1;
	        }
	    }
	 
	    result = result + sign*prev;
	    return result;
	}
	
	public int calculateWithStack(String s)
	{
		int curr=0,sum=0;
		char op='+';
		char[] ch=s.toCharArray();
		Stack<Integer> stack=new Stack<Integer>();
		for(int i=0;i<ch.length;i++)
		{
			if(Character.isDigit(ch[i]))
			{
				curr=(curr*10)+(ch[i]-'0');
			}
			
			if(!Character.isDigit(ch[i])&& ch[i]!=' ' || i==ch.length-1)
			{
				if(op=='+')
				{
					stack.push(curr);
				}
				else if(op=='-')
				{
					stack.push(-curr);
				}
				else if(op=='*')
				{
					stack.push(stack.pop()*curr);
				}
				else if(op=='/')
					{
							stack.push(stack.pop()/curr);
					}		
				
				op=ch[i];
				curr=0;
			}
		 	
		}
	
	while(!stack.isEmpty())
	{
		sum+=stack.pop();
	}
	return sum;
	}
}
