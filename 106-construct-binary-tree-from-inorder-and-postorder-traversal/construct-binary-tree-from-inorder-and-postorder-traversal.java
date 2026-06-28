class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inMap.put(inorder[i], i);
        return constructTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inMap);
    }

    public TreeNode constructTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> inMap) {
        if (inStart > inEnd || postStart > postEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = inMap.get(root.val);
        int leftNums = inRoot - inStart;
        root.left = constructTree(inorder, inStart, inRoot - 1, postorder, postStart, postStart + leftNums - 1, inMap);
        root.right = constructTree(inorder, inRoot + 1, inEnd, postorder, postStart + leftNums, postEnd - 1, inMap);
        return root;
    }
}