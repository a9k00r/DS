/** problem statement :  

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

 

Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3is the length of the path [4,2,1,3] or [5,2,1,3].

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public int diameterOfBinaryTree(TreeNode root) {
        int res = 0;
        if (root == null )
            return res;
        
        int curr = maxDepth(root.left) + maxDepth(root.right);
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        
        return Math.max( curr, Math.max(left, right));
    }
    
    public int maxDepth(TreeNode root){
        if (root == null) return 0;
        
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}