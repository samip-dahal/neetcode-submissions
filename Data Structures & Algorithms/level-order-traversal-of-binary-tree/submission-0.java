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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderTraversal = getLevelOrderTraversal(root);
        return levelOrderTraversal;
    }

    private List<List<Integer>> getLevelOrderTraversal(TreeNode node) {
        List<List<Integer>> levelOrderTraversal = new ArrayList<>();

        if (node == null) {
            return levelOrderTraversal;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(node);

        while (!queue.isEmpty()) {
            int currQueueSize = queue.size();
            List<Integer> levelNodes = new ArrayList<>();

            while (currQueueSize-- > 0) {
                TreeNode nodePopped = queue.removeFirst();
                levelNodes.add(nodePopped.val);
                
                if (nodePopped.left != null) {
                    queue.addLast(nodePopped.left);
                }
                if (nodePopped.right != null) {
                    queue.addLast(nodePopped.right);
                }
            }
            levelOrderTraversal.add(new ArrayList<>(levelNodes));
        }
        return levelOrderTraversal;
    }
}
