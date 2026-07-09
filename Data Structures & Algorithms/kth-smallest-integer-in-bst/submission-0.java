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
    private int kthSmallestValue = -1;
    private int cnt = 0;

    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return kthSmallestValue;
    }

    private void helper(TreeNode node, int k) {
        
        if (node == null) {
            return;
        }
        
        helper(node.left, k);
        cnt++;
        if (cnt == k) {
            kthSmallestValue = node.val;
            return;
        }
        helper(node.right, k);
    }
}
