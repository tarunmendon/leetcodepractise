package src.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CheckAnagram {

	public static void main(String[] args) {
		CheckAnagram objMain=new CheckAnagram();
		
		String s = "anagram", t = "nagaram";
		
		System.out.println(objMain.isAnagram(s, t));
		System.out.println(objMain.isAnagram("rat", "car"));
	}

	  public boolean isAnagram(String s, String t) {
	     Map<Character,Integer> map=new HashMap();
		 int i=0,j=0;
	     
		 while(i<s.length())
	     {
			 if(map.containsKey(s.charAt(i)))
				 map.put(s.charAt(i), map.get(s.charAt(i))+1);
			 else
				 map.put(s.charAt(i), 1);
	     i++;
	     }
		 
		 while(j<t.length())
		 {
			 if(!map.containsKey(t.charAt(j)))
				 return false;
			 else
			 {
				 int cnt=map.get(t.charAt(j));
				 
				 if(cnt==1)
					 map.remove(t.charAt(j));
				 else
					 map.put(t.charAt(j), --cnt);
			 }
			j++;	 
		 }
		 
	     if(map.size()==0)
	    	 return true;
	     else
	    	 return false;
	    }
}
