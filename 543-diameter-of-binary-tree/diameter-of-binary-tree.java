class Solution {
    int maxD = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        findDiameter(root);
        return maxD;
    }
    public int findDiameter(TreeNode node) {
        if(node==null) return 0;
        int leftD = findDiameter(node.left);
        int rightD = findDiameter(node.right);
        maxD = Math.max(maxD,leftD+rightD);
        return 1+Math.max(leftD,rightD);

    }
}