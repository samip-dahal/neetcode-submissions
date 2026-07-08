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
    public List<Integer> rightSideView(TreeNode root) {
        return getRightViewNodes(root);
    }

    private List<Integer> getRightViewNodes(TreeNode node) {

        List<Integer> nodes = new ArrayList<>();
        
        if (node == null) {
            return nodes;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(node);

        while (!queue.isEmpty()) {
            int currQueueSize = queue.size();
            boolean isNodeAdded = false;
            
            while (currQueueSize-- > 0) {
                TreeNode nodePopped = queue.removeFirst();
                if (!isNodeAdded) {
                    nodes.add(nodePopped.val);
                    isNodeAdded = true;
                }

                if (nodePopped.right != null) {
                    queue.addLast(nodePopped.right);
                }
                if (nodePopped.left != null) {
                    queue.addLast(nodePopped.left);
                }
            }
        }
        return nodes;
    }
}
