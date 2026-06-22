
class Solution {
    int maxD=0;
    public int diameterOfBinaryTree(TreeNode root) {
        Diameter(root);
        return maxD;  
    }
    int Diameter(TreeNode root) {
        if(root==null) return 0;
        int Dleft=Diameter(root.left);
        int Dright = Diameter(root.right);
        maxD=Math.max(maxD,Dleft+Dright);
        return 1+Math.max(Dleft,Dright);
    }

}
