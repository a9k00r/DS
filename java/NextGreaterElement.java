/**
Problem: Next Greater Element [Medium]

Given an array arr[ ] of size N having distinct elements, the task is to find the next greater element
for each element of the array in order of their appearance in the array.Next greater element of an element
in the array is the nearest element on the right which is greater than the current element.If there does
not exist next greater of current element, then next greater element for current element is -1. 
For example, next greater of the last element is always -1.
*/

class Solution {
    
    public static long[] nextLargerElement(long[] arr, int n) { 
        long [] res = new long[arr.length];
        Stack<Long> stack = new Stack<Long>();
        for (int i = arr.length -1; i>=0; i--) {
            while (!stack.empty() && arr[i] > stack.peek())
                stack.pop();
            
            res [i] = stack.empty() ? -1 : stack.peek();
            stack.push(arr[i]);
        } 
        return res;
    }
}