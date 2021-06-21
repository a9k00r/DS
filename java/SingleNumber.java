/**
 * [Google]
 Given an integer array nums where every element appears three times except for one, 
 which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant 
extra space.

 

Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99
*/

// Naive T = O(n) & S = O(n)

class Solution {
    public int singleNumber(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int e : nums)
            map.put(e, map.getOrDefault(e, 0) + 1);
        
        for (Map.Entry<Integer, Integer> e : map.entrySet())
            if (e.getValue() == 1)
                return e.getKey();
        
        return -1;
        
    }
}

// Bitwise XOR T = O(n) & S = O(1)
// cp question?id=7902674

class Solution {
    public int singleNumber(int[] nums) {

        int first = 0, second = 0;

        for (int value : nums) {
            first = (first ^ value) & ~second;
            second = (second ^ value) & ~first;
        }
        return first;

    }
}
