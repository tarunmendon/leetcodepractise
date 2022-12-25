package src.leetcode.easy;

import java.util.HashMap;

public class IsomorphicStrings {

	public static void main(String[] args) {
		IsomorphicStrings isomporphicStrings=new IsomorphicStrings();
		//System.out.println(isomporphicStrings.isIsomorphic("add", "bee"));
		System.out.println(isomporphicStrings.isIsomorphic("paper", "title"));
		System.out.println(isomporphicStrings.isIsomorphic("badc", "baba"));
	}

	  public boolean isIsomorphic(String s, String t) {
	     if(s==null||t==null||s.length()!=t.length())
	    	 return false;
		 
	     HashMap<Character,Character> map=new HashMap<Character,Character>();
	     
	     for(int i=0;i<s.length();i++)
	     {
	    	 if(map.containsKey(s.charAt(i))||map.containsKey(t.charAt(i)))
	    	 {
	    		 if((!map.containsKey(s.charAt(i)))||map.get(s.charAt(i))!=t.charAt(i))
	    			 return false;
	    	 }
	    	 map.put(s.charAt(i),t.charAt(i));
	    	 map.put(t.charAt(i),s.charAt(i));
	     }
		  return true;
	    }
}
