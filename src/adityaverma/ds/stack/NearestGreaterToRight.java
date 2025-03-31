package src.adityaverma.ds.stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestGreaterToRight {

    public static void main(String[] args) {
/*
arr[]: {1,3,2,4}
out[]: {3,4,4,-1}
 */
        NearestGreaterToRight obj = new NearestGreaterToRight();
        int[] arr = new int[]{1, 3, 2, 4};
        int[] ngr = obj.nearestGreaterToRight(arr);
        System.out.println(Arrays.stream(ngr).mapToObj(val -> "" + val).reduce((val1, val2) -> val1 + "," + val2));
    }

    public int[] nearestGreaterToRight(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] ngr = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.size() == 0) {
                ngr[i] = -1;
            } else if (stack.peek() > arr[i]) {
                ngr[i] = stack.peek();
            } else if (stack.peek() <= arr[i]) {
                while (stack.size() > 0 && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                if (stack.size() == 0) {
                    ngr[i] = -1;
                } else {
                    ngr[i] = stack.peek();
                }
            }
            stack.push(arr[i]);
        }
        return ngr;
    }
}
