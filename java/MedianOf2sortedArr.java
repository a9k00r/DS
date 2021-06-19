/**
Given two sorted arrays nums1 and nums2 of size m and n respectively,
return the median of the two sorted arrays.

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int []nums= new int [nums1.length + nums2.length];
        int i=0,j=0,k=0;
        double res;
        
        while(i < nums1.length && j < nums2.length)
			if (nums1[i] < nums2[j])
				nums[k++] = nums1[i++];
            else
				nums[k++] = nums2[j++];
		
		while (i < nums1.length)
				nums[k++] = nums1[i++];
		while (j < nums2.length)
				nums[k++] = nums2[j++];

        if (nums.length % 2 == 1)
             res = (double) nums[nums.length/2] ;
        else
             res = (double)(nums[nums.length/2] + nums[(nums.length-1)/2 ])/2;

        return res;
    }
}