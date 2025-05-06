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
    int depth = Integer.MIN_VALUE;
    public int maxDepth(TreeNode root) {
        count(root, 0);
        return depth;
    }

    public void count(TreeNode node, int cnt){
        if(node == null){
            depth = Math.max(depth, cnt);
            return;
        }

        count(node.left, cnt + 1);
        count(node.right, cnt + 1);

    }
}