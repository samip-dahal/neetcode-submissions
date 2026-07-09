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
    private int goodNodeCount = 0;

    public int goodNodes(TreeNode root) {
        helper(root, Integer.MIN_VALUE);
        return goodNodeCount;
    }

    private void helper(TreeNode node, int currMax) {
        
        if (node == null) {
            return;
        }

        if (node.val >= currMax) {
            goodNodeCount++;
            currMax = node.val;
        }

        helper(node.left, currMax);
        helper(node.right, currMax);
    }
}
