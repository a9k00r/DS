/**
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
*/

class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int l = nums.length;
        int [] result = new int[l];
        int i = 0, j = l - 1;
        for (int p = l - 1; p >= 0; p--) {
            int left = nums[i] * nums[i];
            int right = nums[j] * nums[j];
            if (left > right) {
                result[p] = left;
                i++;
            } else {
                result[p] = right ;
                j--;
            }
        }
        return result;
    }

}