class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder=new int[preorder.length];
        for(int i=0;i<preorder.length;i++) inorder[i]=preorder[i];
        Arrays.sort(inorder);
        HashMap<Integer,Integer> inMap= new HashMap<>();
        for(int i=0;i<inorder.length;i++) inMap.put(inorder[i],i);
        return constructTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inMap);

    }
    public TreeNode constructTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> inMap) {
        if(preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;
        root.left = constructTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = constructTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);
        return root;
    }
}