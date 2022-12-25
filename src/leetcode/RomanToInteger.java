package src.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	public static void main(String[] args) {
		RomanToInteger romanInteger=new RomanToInteger();
		
		System.out.println(romanInteger.romanToInt("II"));
		System.out.println(romanInteger.romanToInt("LVIII"));
	}
	 public int romanToInt(String s) {
	        int output=0;
	    Map<Character,Pair<Integer,Integer>> romanInt=new HashMap();
	    romanInt.put('I',new Pair<Integer,Integer>(1,1));
	    romanInt.put('V',new Pair<Integer,Integer>(2,5));
	    romanInt.put('X',new Pair<Integer,Integer>(3,10));
	    romanInt.put('L',new Pair<Integer,Integer>(4,50));
	    romanInt.put('C',new Pair<Integer,Integer>(5,100));
	    romanInt.put('D',new Pair<Integer,Integer>(6,500));
	    romanInt.put('M',new Pair<Integer,Integer>(7,1000));
	    
	    char prev='\0';
	    for(int i=s.length()-1;i>=0;i--)
	    {
	    	if(prev!='\0')
	    	{
	    		int prevPos=romanInt.get(prev).getPosVal();
	    		int currPos=romanInt.get(s.charAt(i)).getPosVal();
	    		
	    		if(prevPos>currPos)
	    			output-=romanInt.get(s.charAt(i)).getIntVal();
	    		else
	    			output+=romanInt.get(s.charAt(i)).getIntVal();
	    	}
	    	else
	    		output+=romanInt.get(s.charAt(i)).getIntVal();
	    	
	    	
	    	prev=s.charAt(i);
	    }
	 return output;
	 }
	 
class Pair<I,T>
{
	I posVal;
	T intVal;
	
	public I getPosVal() {
		return posVal;
	}

	public void setPosVal(I posVal) {
		this.posVal = posVal;
	}

	public T getIntVal() {
		return intVal;
	}

	public void setIntVal(T intVal) {
		this.intVal = intVal;
	}

	Pair(I posVal,T intVal)
	{
		this.posVal=posVal;
		this.intVal=intVal;
	}
}
}
