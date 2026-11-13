class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<n;i++) {
            map.put(inorder[i],i);
        }
        return createTree(preorder,inorder,map,0,n-1,0,n-1);
        
    }
    public TreeNode createTree(int[] preorder,int[] inorder,Map<Integer,Integer> map,int preStart,int preEnd,int inStart,int inEnd) {
        if(preStart> preEnd || inStart > inEnd) return null;
        TreeNode node = new TreeNode(preorder[preStart]);
        int inRoot = map.get(preorder[preStart]);
        int numsLeft = inRoot - inStart;
        node.left=createTree(preorder,inorder,map,preStart+1,preStart+numsLeft,inStart,inRoot-1);
        node.right=createTree(preorder,inorder,map,preStart+numsLeft+1,preEnd,inRoot+1,inEnd);
        return node;
    }
}