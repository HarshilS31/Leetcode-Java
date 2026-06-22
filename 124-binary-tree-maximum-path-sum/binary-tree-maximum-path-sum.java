class Solution {
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMaxSum(root);
        return maxSum;
        
    }
    public int findMaxSum(TreeNode node) {
        if(node==null) return 0;
        int leftSum=Math.max(0,findMaxSum(node.left));
        int rightSum=Math.max(0,findMaxSum(node.right));
        int totalSum=node.val+leftSum+rightSum;
        maxSum=Math.max(maxSum,totalSum);
        return node.val+Math.max(leftSum,rightSum);
    }
}