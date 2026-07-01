class Solution {
    int index=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildBST(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public TreeNode buildBST(int[] preorder,int min,int max) {
        if(index>=preorder.length || preorder[index]<min || preorder[index]>max) return null;
        int val=preorder[index];
        TreeNode root = new TreeNode(preorder[index++]);
        root.left=buildBST(preorder,min,val);
        root.right=buildBST(preorder,val,max);
        return root;
        

    }
}