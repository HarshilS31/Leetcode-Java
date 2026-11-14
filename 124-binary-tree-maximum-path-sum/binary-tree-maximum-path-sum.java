class Solution {
    public int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        maxSum(root);
        return max;
    }
    public int maxSum(TreeNode node) {
        if(node==null) return 0;
        int leftSum=Math.max(0,maxSum(node.left));
        int rightSum=Math.max(0,maxSum(node.right));
        max=Math.max(max,node.val+leftSum+rightSum);
        return node.val+Math.max(leftSum,rightSum);
    }


}