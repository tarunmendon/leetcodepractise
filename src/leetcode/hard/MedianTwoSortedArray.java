package src.leetcode.hard;

public class MedianTwoSortedArray {

	public static void main(String args[])
	{
		MedianTwoSortedArray obj=new MedianTwoSortedArray();
		System.out.println(obj.findMedianSortedArrays(new int[] {1,3}, new int[] {2}));
		System.out.println(obj.findMedianSortedArrays(new int[] {1,2}, new int[] {3,4}));
	}
	
	   public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		     int i=0;
		     int j=0;
		     int size=nums1.length+nums2.length;   
		     int[] out=new int[size];   
		       int k=0; 
		        while(i<nums1.length && j<nums2.length)
		        {
		            if(nums1[i]<nums2[j])
		            { 
		             out[k++]=nums1[i++];
		            }   
		            else
		            {
		                out[k++]=nums2[j++];
		            }    
		        }
		        while(i<nums1.length)
		            out[k++]=nums1[i++];

		        while(j<nums2.length)
		            out[k++]=nums2[j++];

		        if(out.length%2==0)
		        {
		            return (out[(size/2)-1]+out[size/2])/2.0d;
		        }
		        else
		        {
		            return out[size/2];
		        }
		    }
}
