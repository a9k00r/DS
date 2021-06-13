public class Solution {

    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0)
            return 0;

        int[] lis = new int[nums.length];

        for (int i=0; i< lis.length; i++)
            lis[i] = 1;
        
        int longest = 1;
            
        for (int i = 1; i < nums.length; i++)
            for (int j = 0; j < i;  j++)
                if (nums[i] > nums[j] && lis[i] <= lis[j])
                    lis[i] = 1 + lis[j];
        
        for (int e : lis)
            longest = Math.max(longest, e);
           
        return longest;
 
    }
        
}