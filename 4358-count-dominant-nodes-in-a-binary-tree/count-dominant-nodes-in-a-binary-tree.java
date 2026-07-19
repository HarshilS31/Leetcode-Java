class Solution {
    int dominantCount = 0;
    public int countDominantNodes(TreeNode root) {
        dominantCount = 0;
        helper(root);
        return dominantCount;
    }
    public int helper(TreeNode node) {
        if (node == null) return Integer.MIN_VALUE;
        int leftMax = helper(node.left);
        int rightMax = helper(node.right);
        int currentMax = Math.max(node.val, Math.max(leftMax, rightMax));
        if (node.val == currentMax) {
            dominantCount++;
        }
        return currentMax;
    }
}   