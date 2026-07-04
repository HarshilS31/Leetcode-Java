class Solution {
    int maxDia=0;
    public int diameterOfBinaryTree(TreeNode root) {
        findmaxD(root);
        return maxDia;
        
    }
    public int findmaxD(TreeNode node) {
        if(node==null) return 0;
        int leftDia=findmaxD(node.left);
        int rightDia=findmaxD(node.right);
        maxDia=Math.max(maxDia,rightDia+leftDia);
        return 1+Math.max(leftDia,rightDia);


    }
}