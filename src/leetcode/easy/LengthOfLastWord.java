package src.leetcode.easy;

public class LengthOfLastWord {

	   public int lengthOfLastWord(String s) {
	        int size=0;
	        
	        if(s!=null)
	        	s=s.trim();
	        for(int i=s.length()-1;i>=0;i--)
	        { 
	            if(s.charAt(i)==' ')
	                break;
	           size++; 
	        }
	        return size;
	    }
public static void main(String[] args)
{
	LengthOfLastWord lengLastWord=new LengthOfLastWord();
	System.out.println(lengLastWord.lengthOfLastWord("a "));
}
}
