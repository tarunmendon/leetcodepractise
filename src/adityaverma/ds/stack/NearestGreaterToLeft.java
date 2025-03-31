package src.adityaverma.ds.stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestGreaterToLeft {

    public static void main(String[] args) {
        /*
        i/p->1,3,2,4
        ngl=-1,-1,3,-1
         */
        int[] arr = new int[]{1, 3, 2, 4};
        NearestGreaterToLeft ngl = new NearestGreaterToLeft();
        int[] out = ngl.nearestGreaterToRight(arr);
        System.out.println("Nearest Greater To Left:" + Arrays.stream(out).mapToObj(val -> "" + val).reduce((v1, v2) -> v1 + "," + v2));
    }

    public int[] nearestGreaterToRight(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] ngl = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (stack.size() == 0) {
                ngl[i] = -1;
            } else if (stack.peek() > arr[i]) {
                ngl[i] = stack.peek();
            } else if (stack.peek() <= arr[i]) {
                while (stack.size() > 0 && stack.peek() <= arr[i]) {
                    stack.pop();
                }

                if (stack.size() == 0) {
                    ngl[i] = -1;
                } else {
                    ngl[i] = stack.peek();
                }
            }
            stack.push(arr[i]);
        }
        return ngl;
    }
}
