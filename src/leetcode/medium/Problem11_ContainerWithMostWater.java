package src.leetcode.medium;

public class Problem11_ContainerWithMostWater {

    public static void main(String[] args)
    {
        Problem11_ContainerWithMostWater obj=new Problem11_ContainerWithMostWater();
        int[] height=new int[]{1,8,6,2,5,4,8,3,7};
        //System.out.println("Container with most water:"+obj.maxArea(height));

        height=new int[]{1};
        System.out.println("Container with most water:"+obj.maxArea(height));

    }

    /*
    https://www.youtube.com/watch?v=w7ftYsZtIbs
    Nikhil Lohia solution
     */
    public int maxArea(int[] height) {
       if(height==null)
           return 0;
       if(height.length==1)
           return height[0];

       int left=0,right=height.length-1,maxArea=0;

       while(left<=right)
       {
           maxArea=Math.max(maxArea,Math.min(height[left],height[right])*(right-left));

           /* Go to the next greater number */
           if(height[left]<height[right])
               left++;
           else
               right--;
       }
    return maxArea;
    }
}
