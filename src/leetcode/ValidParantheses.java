package src.leetcode;

import java.util.Stack;

public class ValidParantheses {

	public static void main(String[] args) {
		ValidParantheses parantheses = new ValidParantheses();
		
		System.out.println("{{[]}}:"+parantheses.isValid("{{[]}}"));
		System.out.println("{{[}}:"+parantheses.isValid("{{[}}"));
		System.out.println("]]:"+parantheses.isValid("]]"));
	}
	 public boolean isValid(String s) {
	 //s=""()[{}]"
		 Stack<Character> stack=new Stack();
		 
		 for(int i=0;i<s.length();i++)
		 {
			 char c=s.charAt(i);
			 
			 switch(c)
			 {
			 case '(':
			 case '[':
			 case '{':
				 stack.push(c);
				 break;
			 case ')':
			 case ']':
			 case '}':
				 if(stack.isEmpty())
					 return false;
				 char o=stack.pop();
				 if (!((o=='{' && c=='}')||(o=='[' && c==']')||(o=='(' && c==')')))
				   return false;
				 break;
			default : //do nothing
				break;
			 }
			 
		 }
		 if(stack.size()!=0)
			 return false;
	 
		 return true;
	    }
	}