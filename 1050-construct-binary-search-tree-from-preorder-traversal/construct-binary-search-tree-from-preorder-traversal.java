class Solution {
    private int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return solve(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private TreeNode solve(int[] preorder, int min, int max) {
        if (index >= preorder.length || preorder[index] < min || preorder[index] > max) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index++]);
        root.left = solve(preorder, min, root.val);
        root.right = solve(preorder, root.val, max);

        return root;
    }
}