package src.leetcode.medium;

public class Problem43_MultiplyStrings {

    public static void main(String[] args) {
        String num1 = "123", num2 = "456";
        Problem43_MultiplyStrings obj = new Problem43_MultiplyStrings();
        System.out.println(obj.multiply(num1, num2));
        System.out.println(obj.multiply_ProgramCreek(num1, num2));
    }

    //https://www.youtube.com/watch?v=1vZswirL8Y8
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.equals("0") || num2.equals("0"))
            return "0";

        StringBuffer strBuffer = new StringBuffer();
        int[] mul = new int[num1.length() + num2.length()];
        String num1_rev = new StringBuffer(num1).reverse().toString();
        String num2_rev = new StringBuffer(num2).reverse().toString();
        int carry = 0, n1 = 0, n2 = 0, val = 0;

        for (int i = 0; i < num1_rev.length(); i++) {
            for (int j = 0; j < num2_rev.length(); j++) {
                n1 = num1_rev.charAt(i) - '0';
                n2 = num2_rev.charAt(j) - '0';
                val = n1 * n2;

               /* mul[i + j] += (val % 10);
                carry = (val / 10);
                mul[i + j + 1] += carry;*/
                mul[i + j] += val;
                mul[i+j+1]+=(mul[i + j]/10);
                mul[i + j ] = (mul[i + j ]%10);

            }
        }

        //Contains index position of removed zeros
        int startCounter = mul.length - 1;
        while (mul[startCounter] == 0)
            startCounter--;
        for (int i = startCounter; i >= 0; i--) {
            strBuffer.append(mul[i]);
        }
        return strBuffer.toString();
    }

    public String multiply_ProgramCreek(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        int[] d = new int[num1.length()+num2.length()];

        //multiply each digit and sum at the corresponding positions
        for(int i=0; i<n1.length(); i++){
            for(int j=0; j<n2.length(); j++){
                d[i+j] += (n1.charAt(i)-'0') * (n2.charAt(j)-'0');
            }
        }

        StringBuilder sb = new StringBuilder();

        //calculate each digit
        for(int i=0; i<d.length; i++){
            int mod = d[i]%10;
            int carry = d[i]/10;
            if(i+1<d.length){
                d[i+1] += carry;
            }
            sb.insert(0, mod);
        }

        //remove front 0's
        while(sb.charAt(0) == '0' && sb.length()> 1){
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
