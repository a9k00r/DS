/**
Given the root of a binary tree, return the leftmost value in the last row ofthe tree.
Example 1:


Input: root = [2,1,3]
Output: 1
Example 2:


Input: root = [1,2,3,4,null,5,6,null,null,7]
Output: 7

*/

class Solution {
    
   public int findBottomLeftValue(TreeNode root) {
       if (root == null)
           return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null)
                queue.offer(root.right);
            if (root.left != null)
                queue.offer(root.left);
        }
        return root.val;
    }
}
