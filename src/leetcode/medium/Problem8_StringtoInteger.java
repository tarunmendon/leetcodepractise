package src.leetcode.medium;

public class Problem8_StringtoInteger {

    public static void main(String args[]) {
        char character = '+';
        System.out.println(character + " " + (int) character);
        character = '-';
        System.out.println(character + " " + (int) character);
        character = 'a';
        System.out.println(character + " " + (int) character);
        character = 'z';
        System.out.println(character + " " + (int) character);
        character = 'A';
        System.out.println(character + " " + (int) character);
        character = 'Z';
        System.out.println(character + " " + (int) character);
        character = '0';
        System.out.println(character + " " + (int) character);
        System.out.println((char) 91);

        Problem8_StringtoInteger obj = new Problem8_StringtoInteger();
        String s = "9223372036854775808";
        System.out.println(s + ":" + obj.myAtoi(s));
    }

    public int myAtoi(String s) {
        long out = 0;
        char sign =' ';
        int index=0;
       for(int i=0;i<s.length();i++)
       {
           if(s.charAt(i)!=' ') {
               if (s.charAt(i) == '+' || s.charAt(i) == '-')
               {
                   sign =s.charAt(i);
                   index=i+1;
                   break;
               }
               else if(Character.isDigit(s.charAt(i)))
               {
                   index=i;
                   break;
               }
               else
                   return 0;

           }
       }
       for(int i=index;i<s.length();i++)
       {
           if(Character.isDigit(s.charAt(i)))
           {
            out=(out*10)+s.charAt(i)-48;
            if(out>Integer.MAX_VALUE)
                break;
           }
           else {
               break;
           }
       }
       if(sign=='-' && out>Integer.MAX_VALUE)
           return Integer.MIN_VALUE;
       else if(sign=='-'&& out<=Integer.MAX_VALUE)
           return (int)-out;
       else if(out>Integer.MAX_VALUE)
           return Integer.MAX_VALUE;

       return (int)out;
    }
}
